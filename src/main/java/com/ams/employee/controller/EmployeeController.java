package com.ams.employee.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.ams.employee.data.EmployeeRepository;
import com.ams.employee.model.Employee;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	EmployeeRepository repo;

    @GetMapping
    public String showIndexPage(Model model) {
        return "index";
    }

    @GetMapping("/view")
    public String getAll(Model model, @RequestParam(name = "search", required = false) String search){
		List<Employee> employeeList = new ArrayList<Employee>();
		if(search!=null && !search.isEmpty())
			employeeList = repo.findByNameContainingIgnoreCase(search);
		else 
			employeeList= repo.findAll();
		model.addAttribute("employeeList", employeeList);
		return "employee_list";
	}

	@GetMapping("/blacklist")
	public String getAllBlacklist(Model model) {
    List<Employee> employeeList;
    employeeList = repo.findByStatus("Blacklist");
    model.addAttribute("employeeList", employeeList);
    return "blacklist";
	}

	@GetMapping("/blacklist/{id}")
	public String blacklistEmployee(@PathVariable int id) {
    Optional<Employee> optionalEmployee = repo.findById(id);

    if (optionalEmployee.isPresent()) {
        Employee employee = optionalEmployee.get();

        // Only update the status if the current status is not 'Blacklist'
        if (!"Blacklist".equals(employee.getStatus())) {
            employee.setStatus("Blacklist");
            repo.save(employee);
        }
    }
    return "redirect:/employee/view";
}
	

    @GetMapping("/addForm")
    public String showAddingForm(Model model) {
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "add_emp";
    }

    @PostMapping("/add")
    public String createEmployee(@ModelAttribute("employee") Employee employee) {
        repo.save(employee);
        return "redirect:/employee/view";
    }
	
	@GetMapping("/update/{id}")
	public String showUpdatingForm(@PathVariable("id") int id, Model model) {
		Employee employee = repo.findById(id).get();
		model.addAttribute("employee", employee);
		return "update";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id) {
		repo.deleteById(id);
		return "redirect:/employee/view";
	}


}
