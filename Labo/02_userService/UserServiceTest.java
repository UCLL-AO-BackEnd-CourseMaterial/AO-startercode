package be.ucll.backend.users.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import be.ucll.backend.users.domain.User;

public class UserServiceTest {
    UserService service = new UserService();
    User amelia, ben, charles, diana, emma;

    @BeforeEach
    public void setUp() {
        service = new UserService();
        service.getAllUsers().clear(); // remove all users added in constructor
        amelia = new User("Amelia", 44, "amelia.anderson@ucll.be", "alpha");
        ben = new User("Ben", 15, "ben.brown@ucll.be", "beta");
        charles = new User("Charles", 65, "charles.clark@ucll.be", "gamma");
        diana = new User("Diana", 13, "diana.davis@ucll.be", "delta");
        emma = new User("Emma", 44, "emma.edwards@ucll.be", "epsilon");

    }

    // // add: happy case
    // @Test
    // void given4Users_whenNewUserIsAdded_thenUserIsAdded() {
    // // given
    // add4UsersToService();
    // assertEquals(4, service.getAllUsers().size());

    // // when
    // service.addUser(emma);

    // // then
    // assertEquals(5, service.getAllUsers().size());
    // assertTrue(service.getAllUsers().contains(emma));
    // }

    // // Tip: when you try to get the first element of an empty array, you get
    // // IndexOutOfBoundException
    // @Test
    // void given4Users_whenNewUserWithAlreadyUsedEmailIsAdded_thenUserIsNotAdded()
    // {
    // // given
    // add4UsersToService();
    // assertEquals(4, service.getAllUsers().size());

    // // when
    // User otherAmelia = new User("AmeliaTheSecond", 20, "amelia.anderson@ucll.be",
    // "alpha");
    // boolean added = service.addUser(otherAmelia);

    // // then
    // assertFalse(added);
    // assertEquals(4, service.getAllUsers().size());
    // assertFalse(service.getAllUsers().contains(otherAmelia));
    // assertTrue(service.getAllUsers().contains(amelia));
    // }

    // @Test
    // void
    // given4UsersWhere2UsersWithAge44_whenSearchForUsersOfAgeAfter43_then2UsersAreReturned()
    // {
    // // given
    // add4UsersToService();

    // // when
    // List<User> usersAged44 = service.getUsersWithAgeOlderThan(43);

    // // then
    // assertEquals(2, usersAged44.size());
    // assertTrue(containsUserWithName(usersAged44, "Amelia"));
    // assertTrue(containsUserWithName(usersAged44, "Charles"));
    // assertFalse(containsUserWithName(usersAged44, "Ben"));
    // }

    // @Test
    // void
    // given4UsersWhere0UsersWithAge80_whenSearchForUsersOlderThan80_thenAnEmpyListIsReturned()
    // {
    // // when
    // add4UsersToService();
    // List<User> usersAged81 = service.getUsersWithAgeOlderThan(80);

    // // then
    // assertEquals(0, usersAged81.size());
    // }

    // @Test
    // void given4Users_whenSearchForOldestUser_thenOldestUserIsReturned() {
    // // given
    // add4UsersToService();

    // // when
    // User oldestUser = service.getOldestUser();

    // // then
    // assertEquals(65, oldestUser.getAge());
    // assertEquals("Charles", oldestUser.getName());
    // }

    // @Test
    // void givenNoUsers_whenSearchForOldestUser_thenNullValueIsReturned() {
    // // when
    // User oldestUser = service.getOldestUser();

    // // then
    // assertNull(oldestUser);
    // }

    // @Test
    // void given4Users_whenSearchForUserWithExistingEmail_thenUserIsReturned() {
    // // when
    // add4UsersToService();
    // User foundUser = service.getUserWithEmail("ben.brown@ucll.be");

    // // then
    // assertEquals(15, foundUser.getAge());
    // assertEquals("Ben", foundUser.getName());
    // }

    // @Test
    // void given4Users_whenSearchForUserWithNonExistingEmail_thenNullIsReturned() {
    // // when
    // add4UsersToService();
    // User foundUser = service.getUserWithEmail("paul.peterson@ucll.be");

    // // then
    // assertNull(foundUser);
    // }

    // @Test
    // void
    // given4Users_whenRemoveExistingUser_thenUserIsRemovedAndRemovedUserIsReturned()
    // {
    // // given
    // add4UsersToService();
    // assertEquals(4, service.getAllUsers().size());

    // // when
    // User removedUser = service.removeUser("ben.brown@ucll.be");

    // // then
    // assertEquals(3, service.getAllUsers().size());
    // assertEquals(15, removedUser.getAge());
    // assertEquals("Ben", removedUser.getName());
    // }

    // @Test
    // void
    // given4Users_whenRemoveNonExistingUser_thenUserIsNotRemovedAndNullValueIsReturned()
    // {
    // // given
    // add4UsersToService();
    // assertEquals(4, service.getAllUsers().size());

    // // when
    // User removedUser = service.removeUser("paul.peterson@ucll.be");

    // // then
    // assertEquals(4, service.getAllUsers().size());
    // assertNull(removedUser);
    // }

    private boolean containsUserWithName(List<User> users, String name) {
        return users.stream().anyMatch(user -> user.getName().equals(name));
    }

    private void add4UsersToService() {
        service.addUser(amelia);
        service.addUser(ben);
        service.addUser(charles);
        service.addUser(diana);
    }
}
