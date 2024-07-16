package com.techar.EntryPointBackend.core.usecase;

import com.techar.EntryPointBackend.config.exception.ErrorExpected;
import com.techar.EntryPointBackend.core.models.AttendanceRecords;
import com.techar.EntryPointBackend.core.models.User;
import com.techar.EntryPointBackend.core.models.UserTitles;
import com.techar.EntryPointBackend.core.models.request.UpdateUserRequest;
import com.techar.EntryPointBackend.core.repository.*;
import com.techar.EntryPointBackend.core.util.DateUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private  final UserRepository userRepository;

    private final AttendanceRecordsRepository attendanceRecordsRepository;

    private final UserStateRepository userStateRepository;

    private final RolRepository rolRepository;

    private final UserTitlesRepository userTitlesRepository;

    private final static Long ID_WORKING = 1L;
    private final static Long ID_OUT_OF_WORK = 2L;

    public User getUser (String userName) throws ErrorExpected {
        return userRepository.findByUserId(userName).orElseThrow(()->  new ErrorExpected("User not found", HttpStatus.BAD_REQUEST));
    }

    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Transactional(rollbackFor = Exception.class)
    public void logInTime (String userName) throws ErrorExpected {
        var user = userRepository.findByUserId(userName).orElseThrow(()->  new ErrorExpected("User not found", HttpStatus.BAD_REQUEST));
        var records = attendanceRecordsRepository.findRecordsForToday(userName);

        if (records.isEmpty()){
            insertRecord(user);
            updateUserState(user, ID_WORKING);
        }else{
            updateRecords(user, records);
        }
    }

    private void insertRecord (User user) {
        var record = new AttendanceRecords();
        record.setUser(user);
        record.setDateIn(DateUtils.getDate());
        attendanceRecordsRepository.save(record);
    }

    private void updateRecords (User user, List<AttendanceRecords> records) throws ErrorExpected {
        for (AttendanceRecords record : records){
            updateRecord(user, record);
        }
    }

    private void updateRecord (User user, AttendanceRecords record) throws ErrorExpected {
        if (record.isDateOff()){
            record.setDateOff(DateUtils.getDate());
            attendanceRecordsRepository.save(record);
            updateUserState(user, ID_OUT_OF_WORK);
        }
    }

    private void updateUserState (User user, Long idState) throws ErrorExpected {
        var newState = userStateRepository.findById(idState).orElseThrow(() -> new ErrorExpected("User State not found", HttpStatus.INTERNAL_SERVER_ERROR));
        user.setUserState(newState);
        userRepository.save(user);
    }

    @Transactional(rollbackFor = Exception.class)
    public User updateUser(String userId, UpdateUserRequest updateUserRequest) throws ErrorExpected {
        return  userRepository.findByUserId(userId).map(user -> {
                user.setLastName(updateUserRequest.getLastName());
                user.setName(updateUserRequest.getName());
                user.setUserId(updateUserRequest.getUserId());
                return userRepository.save(user);
        }).orElseThrow(()->  new ErrorExpected("User not found", HttpStatus.BAD_REQUEST));
    }

    @Transactional(rollbackFor = Exception.class)
    public User updateAllUser(String userId, UpdateUserRequest updateUserRequest) throws ErrorExpected {
        var newRol = rolRepository.findById(Long.valueOf(updateUserRequest.getIdRol())).orElseThrow(() -> new ErrorExpected("Role not found", HttpStatus.BAD_REQUEST));
        var newTitles = userTitlesRepository.findById(Long.valueOf(updateUserRequest.getIdTitles())).orElseThrow(() -> new ErrorExpected("Titles not found", HttpStatus.BAD_REQUEST));

        return  userRepository.findByUserId(userId).map(user -> {
            user.setLastName(updateUserRequest.getLastName());
            user.setName(updateUserRequest.getName());
            user.setUserId(updateUserRequest.getUserId());
            user.setRole(newRol);
            user.setUserTitles(newTitles);
            return userRepository.save(user);
        }).orElseThrow(()->  new ErrorExpected("User not found", HttpStatus.BAD_REQUEST));
    }


}
