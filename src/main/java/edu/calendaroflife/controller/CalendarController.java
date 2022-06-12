package edu.calendaroflife.controller;

import edu.calendaroflife.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;


@RestController
public class CalendarController implements Api {


    private final UserService userService;

    public CalendarController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("")
    public String getCalendar(HttpServletRequest request) {
        System.out.println(userService.findUserById(1));
        return "get";
    }

    @PostMapping("/week/edit/{id}")
    public String editWeek(@PathVariable Integer id, @RequestBody Integer year) {
        return "edit";
    }

    @PostMapping("/week/add")
    public String addWeek(Integer year, Integer week,
                          Integer[] color, String text, String title) {
        return "add";
    }

    @PostMapping("/week/delete/{id}")
    public String deleteWeek(@PathVariable("id") Integer id) {
        return "delete";
    }

}
