package springdemo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import hibernate.*;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String showPatients(Model model) {
        List<Patient> patients = patient_DAO.getAllPatients();
        model.addAttribute("patients", patients);
        return "main-menu";
    }
}

