package firtspring.springcode;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class EmployeeService
{@Autowired
    private myRepo repo;
    
    public List<Employee> displayData()
    {
        return repo.findAll();
    }
    public void saveProduct(Employee product)
    {
        repo.save(product);
    }
    public Employee getPro(long id)
    {
        return repo.findById(id).get();
    }
    public void delete(long id)
    {
        repo.deleteById(id);
    }
}



