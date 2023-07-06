package com.fas.admin.repository;

import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class AdminRepositoryTest {
//    @Autowired
//    private IAdminRepository adminRepository;
//
//    @Test
//    public void getUserWithCredentialsTest_1() {
//        User user1 = new User();
//        user1.setUsername("username1");
//        user1.setPassword("12345678");
//        user1.setLoggedIn(false);
//        user1.setType(UserType.ADMIN);
//
//        adminRepository.save(user1);
//        // then
//        assertEquals(1, adminRepository.getUserWithCredentials(user1.getUsername(), user1.getPassword()).size());
//    }
//
//    @Test
//    public void getUserWithCredentialsTest_2() {
//        User user1 = new User();
//        user1.setUsername("username1");
//        user1.setPassword("12345678");
//        user1.setLoggedIn(false);
//        user1.setType(UserType.FARMER);
//
//        adminRepository.save(user1);
//        // then
//        assertEquals(0, adminRepository.getUserWithCredentials("username2", user1.getPassword()).size());
//    }
//
//    @Test
//    public void getUserWithUsernameTest_1() {
//        User user1 = new User();
//        user1.setUsername("username1");
//        user1.setPassword("12345678");
//        user1.setLoggedIn(false);
//        user1.setType(UserType.ADMIN);
//
//        adminRepository.save(user1);
//        // then
//        assertEquals(1, adminRepository.getUserWithUsername(user1.getUsername()).size());
//    }
//
//    @Test
//    public void getUserWithUsernameTest_2() {
//        User user1 = new User();
//        user1.setUsername("username1");
//        user1.setPassword("12345678");
//        user1.setLoggedIn(false);
//        user1.setType(UserType.FARMER);
//
//        adminRepository.save(user1);
//        // then
//        assertEquals(0, adminRepository.getUserWithUsername("username2").size());
//    }

}
