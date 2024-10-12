package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TeamTest {

    Team team;
    Team other;
    Team duplicate;

    @BeforeEach
    public void setup() {
        team = new Team("test-team");
        other = new Team("other-team");    
        duplicate = new Team("test-team");
        duplicate.addMember("test");
    }

    @Test
    public void getName_returns_correct_name() {
       assert(team.getName().equals("test-team"));
    }

    @Test
    public void toString_returns_correct_string() {
        assertEquals("Team(name=test-team, members=[])", team.toString());
    }

    @Test
    public void equals_returns_correct_boolean() {
        assertEquals(team.equals(team), true);
        assertEquals(team.equals(1), false);
        assertEquals(team.equals(other), false);
        assertEquals(team.equals(duplicate), false);
    }

    @Test
    public void hashCode_returns_correct_boolean() {
        assertEquals(team.hashCode(), (team.getName().hashCode() | team.getMembers().hashCode()));
    }
}
