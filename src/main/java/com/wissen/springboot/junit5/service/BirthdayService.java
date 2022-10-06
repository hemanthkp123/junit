package com.wissen.springboot.junit5.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.wissen.springboot.junit5.exception.InvalidDateFormatException;

@Service
public class BirthdayService {
	private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

	public BirthdayService() {
	}

	public LocalDate getValidBirthday(String birthdayString) {
        if (birthdayString == null) {
            throw new InvalidDateFormatException("Must include birthday",HttpStatus.BAD_REQUEST);
        }
        try {
            LocalDate birthdate = LocalDate.parse(birthdayString, formatter);
            return birthdate;
        } catch (Exception e) {
            throw new InvalidDateFormatException("Must include valid birthday in yyyy-MM-dd format", HttpStatus.BAD_REQUEST);
        }

    }

	public boolean isBirthDatesSameStarSign(LocalDate birthdate1, LocalDate birthdate2) {
		return getStarSign(birthdate1).toString().equals(getStarSign(birthdate2).toString());
	}
    public String getBirthDOW(LocalDate birthday) {
        return birthday.getDayOfWeek().toString();
    }

    public String getStarSign(LocalDate birthday) {
        int day = birthday.getDayOfMonth();
        int month = birthday.getMonthValue();

        if (month == 12 && day >= 22 || month == 1 && day < 20) {
            return "Capricorn";
        } else if (month == 1 && day >= 20 || month == 2 && day < 19) {
            return "Aquarius";
        } else if (month == 2 && day >= 19 || month == 3 && day < 21) {
            return "Pisces";
        } else if (month == 3 && day >= 21 || month == 4 && day < 20) {
            return "Aries";
        } else if (month == 4 && day >= 20 || month == 5 && day < 21) {
            return "taurus";
        } else if (month == 5 && day >= 21 || month == 6 && day < 21) {
            return "Gemini";
        } else if (month == 6 && day >= 21 || month == 7 && day < 23) {
            return "Cancer";
        } else if (month == 7 && day >= 23 || month == 8 && day < 23) {
            return "Leo";
        } else if (month == 8 && day >= 23 || month == 9 && day < 23) {
            return "Virgo";
        } else if (month == 9 && day >= 23 || month == 10 && day < 23) {
            return "Libra";
        } else if (month == 10 && day >= 23 || month == 11 && day < 22) {
            return "Scorpio";
        } else if (month == 11 && day >= 22 || month == 12 && day < 22) {
            return "Sagittarius";
        }
        return "";
    }
}
