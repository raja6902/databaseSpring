package be.raja.data;

import be.raja.model.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;
import java.util.Optional;

public class EmployeeRepositoryimpl implements EmployeeRepository{

    private final EntityManagerFactory entityManagerFactory;

    public EmployeeRepositoryimpl(EntityManagerFactory entityManagerFactory){
        this.entityManagerFactory = entityManagerFactory;
    }
    @Override
    public Employee createEmployee(Employee employee) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        em.persist(employee);
        em.getTransaction().commit();
        return employee;
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        employee = em.merge(employee);
        em.getTransaction().commit();
        return employee;
    }

    @Override
    public boolean deleteEmployee(Employee employee) {
        EntityManager em = entityManagerFactory.createEntityManager();
        Employee checkIfExist = em.find(Employee.class, employee.getId());
        if(checkIfExist==null)return false;

        em.getTransaction().begin();
        em.remove(employee);
        em.getTransaction().commit();

        return true;


    }

    @Override
    public Optional<Employee> findEmployeeById(Long id) {
        EntityManager em = entityManagerFactory.createEntityManager();
        Employee checkIfExist = em.find(Employee.class,id);
        if(checkIfExist == null) return Optional.empty();

        return Optional.of(checkIfExist);
    }

    @Override
    public List<Employee> findAllEmployees() {
        EntityManager em = entityManagerFactory.createEntityManager();
        return em.createQuery("FROM Employee").getResultList();

    }
}
