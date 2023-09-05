package be.ucll.backend.users.service;

import java.util.List;
import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import be.ucll.backend.users.domain.User;
import be.ucll.backend.users.repo.UserRepository;

import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {
    @Mock
    UserRepository userRepository;

    @InjectMocks
    UserService userService;

    private User amelia;
    private User ben;
    private User charles;
    private User diana;
    private User emma;

    @BeforeEach
    public void setUp() {
        // given
        amelia = new User("Amelia", 44, "amelia.anderson@ucll.be", "alpha");
        ben = new User("Ben", 15, "ben.brown@ucll.be", "beta");
        charles = new User("Charles", 65, "charles.clark@ucll.be", "gamma");
        diana = new User("Diana", 13, "diana.davis@ucll.be", "delta");
        emma = new User("Emma", 44, "emma.edwards@ucll.be", "epsilon");

    }

//    // Add User
//    @Test
//    void givenUsers_whenNewUserWithNotAlreadyUsedEmailIsAdded_thenUserIsAdded() throws ServiceException {
//        // given
//        //  mock that there is no user emma in the repo
//        when(userRepository.findUserByEmail(emma.getEmail())).thenReturn(null);
//        when(userRepository.save(emma)).thenReturn(emma);
//
//        // when
//        User added = userService.addUser(emma);
//
//        // then
//        // check if emma is saved to the repo
//        verify(userRepository).save(emma);
//        // check the result of saving
//        assertEquals(emma.getEmail(), added.getEmail());
//
//    }
//
//    @Test
//    void givenUsers_whenNewUserWithAlreadyUsedEmailIsAdded_thenServiceExceptionIsThrown() {
//        // given
//        //  mock that there is already a user emma in the repo
//        when(userRepository.findUserByEmail(emma.getEmail())).thenReturn(emma);
//
//
//        // when
//        ServiceException ex = Assertions.assertThrows(ServiceException.class, ()->userService.addUser(emma));
//
//        // then
//        assertEquals("email", ex.getField());
//        assertEquals("email already taken", ex.getMessage());
//    }
//
//    // Search for user older than
//    @Test
//    public void givenUsersWhith1UserOlderThan20_whenGetUsersOlderThan20_thenListWith1UserOlderThan20IsReturned()
//            throws ServiceException {
//        // given
//        List<User> usersAbove20 = new ArrayList<User>();
//        usersAbove20.add(amelia);
//        when(userRepository.findUsersByAgeAfter(20)).thenReturn(usersAbove20);
//
//        // when
//        List<User> result = userService.getUsersWithAgeOlderThan(20);
//
//        // then
//        assertEquals(usersAbove20.size(), result.size());
//        assertTrue(result.contains(amelia));
//        assertFalse(result.contains(diana));
//    }
//
//    @Test
//    public void givenUsersWhithNoUsersOlderThan20_whenGetUsersOlderThan20_thenServiceExceptionIsThrown() {
//        // given
//        List<User> usersAbove20 = new ArrayList<User>();
//        when(userRepository.findUsersByAgeAfter(20)).thenReturn(usersAbove20);
//
//        // when
//        ServiceException ex = Assertions.assertThrows(ServiceException.class,
//                () -> userService.getUsersWithAgeOlderThan(20));
//
//        // then
//        assertEquals("users", ex.getField());
//        assertEquals("no users with age 20 found", ex.getMessage());
//    }
//
//    @Test
//    void givenUsersWhere2UsersWithAge44_whenSearchForUsersOlderThan43_then2UsersAreReturned() throws ServiceException {
//        // given
//        List<User> usersAbove43 = new ArrayList<>();
//        usersAbove43.add(amelia);
//        usersAbove43.add(ben);
//        when(userRepository.findUsersByAgeAfter(43)).thenReturn(usersAbove43);
//
//        // when
//        List<User> usersAged44 = userService.getUsersWithAgeOlderThan(43);
//
//        // then
//        assertEquals(2, usersAged44.size());
//        assertTrue(containsUserWithName(usersAged44, "Amelia"));// method is defined at the end of the file
//        assertTrue(containsUserWithName(usersAged44, "Ben"));
//        assertFalse(containsUserWithName(usersAged44, "Emma"));
//    }
//
//    @Test
//    void givenUsersWhere0UsersWithAge80_whenSearchForUsersOlderThan80_thenServiceExceptionIsThrown() {
//        // given
//        List<User> usersAbove80 = new ArrayList<>();
//        when(userRepository.findUsersByAgeAfter(80)).thenReturn(usersAbove80);
//
//        // when
//        ServiceException ex = Assertions.assertThrows(ServiceException.class,
//                () -> userService.getUsersWithAgeOlderThan(80));
//
//        // then
//        assertEquals("users", ex.getField());
//        assertEquals("no users with age 80 found", ex.getMessage());
//    }
//
//    // Search for oldest user
//    @Test
//    void given4Users_whenSearchForOldestUser_thenOldestUserIsReturned() throws ServiceException {
//        // given
//        when(userRepository.findFirstByOrderByAgeDesc()).thenReturn(charles);
//
//        // when
//        User oldestUser = userService.getOldestUser();
//
//        // then
//        assertEquals(65, oldestUser.getAge());
//        assertEquals("Charles", oldestUser.getName());
//    }
//
//    @Test
//    void givenNoUsers_whenSearchForOldestUser_thenServiceExceptionIsThrown() {
//        //given
//        when(userRepository.findFirstByOrderByAgeDesc()).thenReturn(null);
//
//        //when
//        ServiceException ex = Assertions.assertThrows(ServiceException.class, ()->userService.getOldestUser());
//
//        // then
//        assertEquals("users", ex.getField());
//        assertEquals("no oldest user found", ex.getMessage());
//    }
//
//    // Search on name
//    @Test
//    void givenUsers_whenSearchForUserWithExistingName_thenUserIsReturned() throws ServiceException {
//        //given
//        when(userRepository.findUserByName("Diana")).thenReturn(diana);
//
//        //when
//        User foundUser = userService.getUserWithName("Diana");
//
//        //then
//        assertEquals(13, foundUser.getAge());
//        assertEquals("Diana", foundUser.getName());
//    }
//
//    @Test
//    void givenUsers_whenSearchForUserWithNonExistingName_thenServiceExceptionIsThrown() {
//        //given
//        when(userRepository.findUserByName("Edward")).thenReturn(null);
//
//        //when
//        ServiceException ex = Assertions.assertThrows(ServiceException.class, ()->userService.getUserWithName("Edward"));
//
//        // then
//        assertEquals("user", ex.getField());
//        assertEquals("no user found with name: Edward", ex.getMessage());
//    }
//
//    // Search on email
//    @Test
//    void givenUsers_whenSearchForUserWithExistingEmail_thenUserIsReturned() throws ServiceException {
//        //given
//        when(userRepository.findUserByEmail("diana.davis@ucll.be")).thenReturn(diana);
//
//        //when
//        User foundUser = userService.getUserWithEmail("diana.davis@ucll.be");
//
//        //then
//        assertEquals(13, foundUser.getAge());
//        assertEquals("Diana", foundUser.getName());
//    }
//
//    @Test
//    void givenUsers_whenSearchForUserWithNonExistingEmail_thenServiceExceptionIsThrown() {
//        //given
//        when(userRepository.findUserByEmail("emma.edwards@ucll.be")).thenReturn(null);
//
//        //when
//        ServiceException ex = Assertions.assertThrows(ServiceException.class, ()->userService.getUserWithEmail("emma.edwards@ucll.be"));
//
//        // then
//        assertEquals("user", ex.getField());
//        assertEquals("no user found with email: emma.edwards@ucll.be", ex.getMessage());
//    }
//
//    // Remove user with email
//    @Test
//    void
//    givenUsers_whenRemoveExistingUserWithEmail_thenUserIsRemovedAndRemovedUserIsReturned() throws ServiceException
//    {
//        //given
//        when(userRepository.findUserByEmail("charles.clark@ucll.be")).thenReturn(charles);
//
//        //when
//        User removedUser = userService.removeUser("charles.clark@ucll.be");
//        verify(userRepository).delete(charles);
//
//        //then
//        assertEquals(charles.getName(), removedUser.getName());
//    }
//
//    @Test
//    void givenUsers_whenRemoveNonExistingUserWithEmail_thenServiceExceptionIsThrown() {
//        // given
//
//        // when
//        ServiceException ex = Assertions.assertThrows(ServiceException.class,
//                () -> userService.getUserWithEmail("emma.edwards@ucll.be"));
//
//        // then
//        assertEquals("user", ex.getField());
//        assertEquals("no user found with email: emma.edwards@ucll.be", ex.getMessage());
//    }
//
//    // Search for user with email and age
//
//    @Test
//    void givenUsers_whenSearchForUserWithExistingEmailAndAge_thenUserIsReturned() throws ServiceException {
//        // given
//        when(userRepository.findUserByEmailAndAge("ben.brown@ucll.be", 15)).thenReturn(ben);
//        // when
//        User foundUser = userService.getUserWithEmailAndAge("ben.brown@ucll.be", 15);
//
//        // then
//        assertEquals(15, foundUser.getAge());
//        assertEquals("Ben", foundUser.getName());
//    }
//
//    @Test
//    void
//    givenUsers_whenSearchForUserWithNonExistingEmailAndExistingAge_thenServiceExceptionIsThrown() {
//
//        // given
//        when(userRepository.findUserByEmailAndAge("paul.peterson@ucll.be", 15)).thenReturn(null);
//        // when
//        ServiceException ex = Assertions.assertThrows(ServiceException.class, ()->userService.getUserWithEmailAndAge("paul.peterson@ucll.be", 15));
//
//        // then
//        assertEquals("user", ex.getField());
//        assertEquals("no user found with email and age: paul.peterson@ucll.be, 15", ex.getMessage());
//    }
//
//    @Test
//    void
//    given4Users_whenSearchForUserWithExistingEmailAndNonExistingAge_thenServiceExceptionIsThrown() {
//
//        // given
//        when(userRepository.findUserByEmailAndAge("ben.brown@ucll.be", 115)).thenReturn(null);
//        // when
//        ServiceException ex = Assertions.assertThrows(ServiceException.class, ()->userService.getUserWithEmailAndAge("ben.brown@ucll.be", 115));
//
//        // then
//        assertEquals("user", ex.getField());
//        assertEquals("no user found with email and age: ben.brown@ucll.be, 115", ex.getMessage());
//    }
//
//    // Search user with age between
//    @Test
//    void given4UsersWhere2UsersWithAgeBetween10And20_whenSearchForUsersOfAgeBetween10And20_then2UsersAreReturned()
//            throws ServiceException {
//        // given
//        List<User> usersAgeBetween10And20 = new ArrayList<User>();
//        usersAgeBetween10And20.add(ben);
//        usersAgeBetween10And20.add(diana);
//
//        when(userRepository.findUsersByAgeBetween(10, 20)).thenReturn(usersAgeBetween10And20);
//
//        // when
//        List<User> result = userService.getUsersWithAgeBetween(10, 20);
//
//        // then
//        assertEquals(2, result.size());
//        assertTrue(containsUserWithName(result, "Ben"));
//        assertTrue(containsUserWithName(result, "Diana"));
//        assertFalse(containsUserWithName(result, "Amelia"));
//    }
//
//    @Test
//    void given4UsersWhere0UsersWithAgeBetween80And90_whenSearchForUsersWithAgeBetween80And90_thenServiceExceptionIsThrown() {
//        // given
//        List<User> usersAgeBetween80And90 = new ArrayList<User>();
//        when(userRepository.findUsersByAgeBetween(80, 90)).thenReturn(usersAgeBetween80And90);
//
//        // when
//        ServiceException ex = Assertions.assertThrows(ServiceException.class,
//                () -> userService.getUsersWithAgeBetween(80, 90));
//
//        // then
//        assertEquals("users", ex.getField());
//        assertEquals("no users found with age between: 80 and 90", ex.getMessage());
//    }

    private boolean containsUserWithName(List<User> users, String name) {
        return users.stream().anyMatch(user -> user.getName().equals(name));
    }

}
