package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

import org.junit.jupiter.api.Test;

public class DeveloperTest {

    @Test
    public void testPrivateConstructor() throws Exception {
        // this hack is from https://www.timomeinen.de/2013/10/test-for-private-constructor-to-get-full-code-coverage/
        Constructor<Developer> constructor = Developer.class.getDeclaredConstructor();
        assertTrue(Modifier.isPrivate(constructor.getModifiers()),"Constructor is not private");

        constructor.setAccessible(true);
        constructor.newInstance();
    }

    @Test
    public void getName_returns_correct_name() {
        assertEquals("Leo", Developer.getName());
    }

    @Test
    public void getGithubId_returns_correct_GithubId() {
        assertEquals("leozhu0", Developer.getGithubId());
    }

    @Test
    public void getTeam_returns_team_with_correct_name() {
        Team  t = Developer.getTeam();
        assertEquals("f24-02", t.getName());
    }

    @Test
    public void getTeam_returns_team_with_correct_members() {
        Team  t = Developer.getTeam();
        assertTrue(t.getMembers().contains("Leo"),"Team should contain Leo");
        assertTrue(t.getMembers().contains("Jeffery"),"Team should contain Jeffery");
        assertTrue(t.getMembers().contains("Rushil"),"Team should contain Rushil");
        assertTrue(t.getMembers().contains("Edwin"),"Team should contain Edwin");
        assertTrue(t.getMembers().contains("Ved"),"Team should contain Ved");
        assertTrue(t.getMembers().contains("Jakob"),"Team should contain Jakob"); 
    }

}
