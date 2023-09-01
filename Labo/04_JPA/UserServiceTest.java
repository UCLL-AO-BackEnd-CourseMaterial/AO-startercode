package be.ucll.backend.users.service;

import java.util.List;
import java.util.ArrayList;

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

    // // Add User
    // @Test
    // void givenUsers_whenNewUserWithNotAlreadyUsedEmailIsAdded_thenUserIsAdded() {
    // // given
    // // mock that there is no user emma in the repo
    // when(userRepository.findUserByEmail(emma.getEmail())).thenReturn(null);
    // when(userRepository.save(emma)).thenReturn(emma);

    // // when
    // User added = userService.addUser(emma);

    // // then
    // // check if emma is saved to the repo
    // verify(userRepository).save(emma);
    // // check the result of saving
    // assertEquals(emma.getEmail(), added.getEmail());

    // }

    // @Test
    // void givenUsers_whenNewUserWithAlreadyUsedEmailIsAdded_thenUserIsNotAdded() {
    // // given
    // // mock that there is already a user emma in the repo
    // when(userRepository.findUserByEmail(emma.getEmail())).thenReturn(emma);

    // // when
    // User added = userService.addUser(emma);

    // // then
    // assertNull(added);
    // }

    // // Search for user older than
    // @Test
    // public void
    // givenUsersWhith1UserOlderThan20_whenGetUsersOlderThan20_thenListWith1UserOlderThan20IsReturned()
    // {
    // // given
    // List<User> usersAbove20 = new ArrayList<User>();
    // usersAbove20.add(amelia);
    // when(userRepository.findUsersByAgeAfter(20)).thenReturn(usersAbove20);

    // // when
    // List<User> result = userService.getUsersWithAgeOlderThan(20);

    // // then
    // assertEquals(usersAbove20.size(), result.size());
    // assertTrue(result.contains(amelia));
    // assertFalse(result.contains(diana));
    // }

    // @Test
    // public void
    // givenUsersWhithNoUsersOlderThan20_whenGetUsersOlderThan20_thenEmptyListIsReturned()
    // {
    // // given
    // List<User> usersAbove20 = new ArrayList<User>();
    // when(userRepository.findUsersByAgeAfter(20)).thenReturn(usersAbove20);

    // // when
    // List<User> result = userService.getUsersWithAgeOlderThan(20);

    // // then
    // assertEquals(usersAbove20.size(), result.size());
    // assertFalse(result.contains(charles));
    // assertFalse(result.contains(diana));
    // }

    // @Test
    // void
    // givenUsersWhere2UsersWithAge44_whenSearchForUsersOlderThan43_then2UsersAreReturned()
    // {
    // // given
    // List<User> usersAbove43 = new ArrayList<>();
    // usersAbove43.add(amelia);
    // usersAbove43.add(ben);
    // when(userRepository.findUsersByAgeAfter(43)).thenReturn(usersAbove43);

    // // when
    // List<User> usersAged44 = userService.getUsersWithAgeOlderThan(43);

    // // then
    // assertEquals(2, usersAged44.size());
    // assertTrue(containsUserWithName(usersAged44, "Amelia"));// method is defined
    // at the end of the file
    // assertTrue(containsUserWithName(usersAged44, "Ben"));
    // assertFalse(containsUserWithName(usersAged44, "Emma"));
    // }

    // @Test
    // void
    // givenUsersWhere0UsersWithAge80_whenSearchForUsersOlderThan80_thenAnEmpyListIsReturned()
    // {
    // // given
    // List<User> usersAbove80 = new ArrayList<>();
    // when(userRepository.findUsersByAgeAfter(80)).thenReturn(usersAbove80);

    // // when
    // List<User> usersAged81 = userService.getUsersWithAgeOlderThan(80);

    // // then
    // assertEquals(0, usersAged81.size());
    // }

    // // Search for oldest user
    // @Test
    // void given4Users_whenSearchForOldestUser_thenOldestUserIsReturned() {
    // // given
    // when(userRepository.findFirstByOrderByAgeDesc()).thenReturn(charles);

    // // when
    // User oldestUser = userService.getOldestUser();

    // // then
    // assertEquals(65, oldestUser.getAge());
    // assertEquals("Charles", oldestUser.getName());
    // }

    // @Test
    // void givenNoUsers_whenSearchForOldestUser_thenNullValueIsReturned() {
    // //given
    // when(userRepository.findFirstByOrderByAgeDesc()).thenReturn(null);

    // //when
    // User oldestUser = userService.getOldestUser();

    // //then
    // assertNull(oldestUser);
    // }

    // // Search on name
    // @Test
    // void givenUsers_whenSearchForUserWithExistingName_thenUserIsReturned() {
    // //given
    // when(userRepository.findUserByName("Diana")).thenReturn(diana);

    // //when
    // User foundUser = userService.getUserWithName("Diana");

    // //then
    // assertEquals(13, foundUser.getAge());
    // assertEquals("Diana", foundUser.getName());
    // }

    // @Test
    // void givenUsers_whenSearchForUserWithNonExistingName_thenNullIsReturned() {
    // //given
    // when(userRepository.findUserByName("Edward")).thenReturn(null);

    // //when
    // User foundUser = userService.getUserWithName("Edward");

    // //then
    // assertNull(foundUser);
    // }

    // // Search on email
    // @Test
    // void givenUsers_whenSearchForUserWithExistingEmail_thenUserIsReturned() {
    // //given
    // when(userRepository.findUserByEmail("diana.davis@ucll.be")).thenReturn(diana);

    // //when
    // User foundUser = userService.getUserWithEmail("diana.davis@ucll.be");

    // //then
    // assertEquals(13, foundUser.getAge());
    // assertEquals("Diana", foundUser.getName());
    // }

    // @Test
    // void givenUsers_whenSearchForUserWithNonExistingEmail_thenNullIsReturned() {
    // //given
    // when(userRepository.findUserByEmail("emma.edwards@ucll.be")).thenReturn(null);

    // //when
    // User foundUser = userService.getUserWithEmail("emma.edwards@ucll.be");

    // //then
    // assertNull(foundUser);
    // }

    // // Remove user with email
    // @Test
    // void
    // givenUsers_whenRemoveExistingUserWithEmail_thenUserIsRemovedAndRemovedUserIsReturned()
    // {
    // //given
    // when(userRepository.findUserByEmail("charles.clark@ucll.be")).thenReturn(charles);

    // //when
    // User removedUser = userService.removeUser("charles.clark@ucll.be");
    // verify(userRepository).delete(charles);

    // //then
    // assertEquals(charles.getName(), removedUser.getName());
    // }

    // @Test
    // void
    // givenUsers_whenRemoveNonExistingUserWithEmail_thenUserIsNotRemovedAndNullValueIsReturned()
    // {
    // //given
    // //given
    // when(userRepository.findUserByEmail("emma.edwards@ucll.be")).thenReturn(null);

    // //when
    // User removedUser = userService.removeUser("emma.edwards@ucll.be");

    // //then
    // assertNull(removedUser);
    // }

    // // Search for user with email and age

    // @Test
    // void givenUsers_whenSearchForUserWithExistingEmailAndAge_thenUserIsReturned()
    // {
    // // given
    // when(userRepository.findUserByEmailAndAge("ben.brown@ucll.be",
    // 15)).thenReturn(ben);
    // // when
    // User foundUser = userService.getUserWithEmailAndAge("ben.brown@ucll.be", 15);

    // // then
    // assertEquals(15, foundUser.getAge());
    // assertEquals("Ben", foundUser.getName());
    // }

    // @Test
    // void
    // givenUsers_whenSearchForUserWithNonExistingEmailAndExistingAge_thenNullIsReturned()
    // {
    // // given
    // when(userRepository.findUserByEmailAndAge("paul.peterson@ucll.be",
    // 15)).thenReturn(null);
    // // when
    // User foundUser = userService.getUserWithEmailAndAge("paul.peterson@ucll.be",
    // 15);

    // // then
    // assertNull(foundUser);
    // }

    // @Test
    // void
    // given4Users_whenSearchForUserWithExistingEmailAndNonExistingAge_thenNullIsReturned()
    // {
    // // given
    // when(userRepository.findUserByEmailAndAge("ben.brown@ucll.be",
    // 115)).thenReturn(null);
    // // when
    // User foundUser = userService.getUserWithEmailAndAge("ben.brown@ucll.be",
    // 115);

    // // then
    // assertNull(foundUser);
    // }

    // // Search user with age between
    // @Test
    // void
    // given4UsersWhere2UsersWithAgeBetween10And20_whenSearchForUsersOfAgeBetween10And20_then2UsersAreReturned()
    // {
    // // given
    // List<User> usersAgeBetween10And20 = new ArrayList<User>();
    // usersAgeBetween10And20.add(ben);
    // usersAgeBetween10And20.add(diana);

    // when(userRepository.findUsersByAgeBetween(10,
    // 20)).thenReturn(usersAgeBetween10And20);

    // // when
    // List<User> result = userService.getUsersWithAgeBetween(10, 20);

    // // then
    // assertEquals(2, result.size());
    // assertTrue(containsUserWithName(result, "Ben"));
    // assertTrue(containsUserWithName(result, "Diana"));
    // assertFalse(containsUserWithName(result, "Amelia"));
    // }

    // @Test
    // void
    // given4UsersWhere0UsersWithAgeBetween80And90_whenSearchForUsersWithAgeBetween80And90_thenAnEmpyListIsReturned()
    // {
    // // given
    // List<User> usersAgeBetween80And90 = new ArrayList<User>();
    // when(userRepository.findUsersByAgeBetween(80,
    // 90)).thenReturn(usersAgeBetween80And90);

    // // when
    // List<User> result = userService.getUsersWithAgeBetween(80, 90);

    // // then
    // assertEquals(0, result.size());
    // }

    private boolean containsUserWithName(List<User> users, String name) {
        return users.stream().anyMatch(user -> user.getName().equals(name));
    }

}
