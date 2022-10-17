package firtspring.springcode;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class MyController
{
	  @Autowired
	    EmployeeService service;
	    
	    @RequestMapping("/")
	    public String showHomePage(Model model)
	    {
	        System.out.println("Display called");
	        List<Employee> list = service.displayData();
	        for(Employee p : list)
	        {
	            System.out.println(p.getId()+" "+p.getName()+" "+p.getsalary());
	        }
	        model.addAttribute("abc",list);
	        return "show";
	    }
	    @RequestMapping("/addData")
	    public String newData(Model model)
	    {
	        Employee product = new Employee();
	        model.addAttribute("product", product);
	        return "add-pro";
	    }
	    @RequestMapping(value = "/save", method = RequestMethod.POST)
	    public String saveAfter(@ModelAttribute("product") Employee product)
	    {
	        service.saveProduct(product);
	        return "redirect:/";
	    }
	    @RequestMapping("/edit/{id}")
	    public ModelAndView editData(@PathVariable(name="id")long id)
	    {
	        ModelAndView modelAndView = new ModelAndView("edit-pro");
	        Employee product=service.getPro(id);
	        modelAndView.addObject("product", product);
	        return modelAndView;
	    }
	    @RequestMapping("/delete/{id}")
	    public String editData(@PathVariable(name="id")int id)
	    {
	        service.delete(id);
	        return "redirect:/";
	    }
}