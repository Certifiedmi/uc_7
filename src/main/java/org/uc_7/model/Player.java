package org.uc_7.model;

import java.util.List;
import java.util.Objects;

public class Player {
    public String name;
    public int age;
    public int experience;
    public List<Integer> skills;


    public Player(String name, int age, int experience, List<Integer> skills) {
        this.name = name;
        this.age = age;
        this.experience = experience;
        this.skills = skills;
    }

    public Player() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public List<Integer> getSkills() {
        return skills;
    }

    public void setSkills(List<Integer> skills) {
        this.skills = skills;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Player)) return false;
        Player player = (Player) o;
        return getAge() == player.getAge() && getExperience() == player.getExperience() && Objects.equals(getName(), player.getName()) && Objects.equals(getSkills(), player.getSkills());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getAge(), getExperience(), getSkills());
    }
}
