package com.study.springmvc;

import com.study.springmvc.domain.City;
import com.study.springmvc.mapper.CityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Hello world!
 */
@Controller
public class App {
    @Autowired
    private CityMapper cityMapper;

    @RequestMapping("/insert")
    @Transactional
    public void insertCity() {
        City city = City.builder().countrycode("IND").id(9999).name("daljdlas").population(23).district("ddd").build();
        cityMapper.insert(city);
        //throw new RuntimeException("xxx");

    }

    @RequestMapping("/query")
    @Transactional
    public City queryCity() {
        City city = City.builder().countrycode("IND").id(9999).name("daljdlas").population(23).district("ddd").build();
        return city;

    }

    @RequestMapping(value="/showname",method= RequestMethod.GET)
    public String showUserName(@RequestParam("uid") int uid, HttpServletRequest request, Model model){
        System.out.println("showname");
        City city = City.builder().countrycode("IND").id(9999).name("daljdlas").population(23).district("ddd").build();

        if(city != null){
            request.setAttribute("name", city.getName());
            model.addAttribute("mame", city.getName());
            return "showName";
        }
        request.setAttribute("error", "没有找到该用户！");
        return "error";
    }
}
