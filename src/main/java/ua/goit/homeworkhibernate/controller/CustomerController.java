package ua.goit.homeworkhibernate.controller;

import ua.goit.homeworkhibernate.config.HibernateProvider;
import ua.goit.homeworkhibernate.model.dto.CustomersDto;
import ua.goit.homeworkhibernate.repository.CustomersRepository;
import ua.goit.homeworkhibernate.service.CustomersService;
import ua.goit.homeworkhibernate.service.convert.CustomersConverter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

@WebServlet(urlPatterns = "/customers/*")
public class CustomerController extends HttpServlet {
    private CustomersService customersService;

    @Override
    public void init() {
        HibernateProvider dbProvider = new HibernateProvider();
        CustomersRepository customersRepository = new CustomersRepository(dbProvider);
        CustomersConverter customersConverter = new CustomersConverter();
        customersService = new CustomersService(customersRepository, customersConverter);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = getAction(req);

        if (action.matches("/all")) {
            List<CustomersDto> customers = customersService.findAll();
            req.setAttribute("customers", customers);
            req.getRequestDispatcher("/view/findAllCustomers.jsp").forward(req, resp);
        }
        else if (action.matches("/form")) {
            req.getRequestDispatcher("/view/findCustomerForm.jsp").forward(req, resp);
        }
        else if (action.matches("/find")) {
            try {
                int customerId = Integer.parseInt(req.getParameter("customerId"));
                CustomersDto customerById = customersService.findById(customerId);
                if (customerById.equals(new CustomersDto())) {
                    String message = String.format("Customer with ID %s not found", customerId);
                    req.setAttribute("message", message);
                    req.getRequestDispatcher("/view/findCustomer.jsp").forward(req, resp);
                } else {
                    req.setAttribute("customer", customerById);
                    req.getRequestDispatcher("/view/findCustomer.jsp").forward(req, resp);
                }
            } catch (NumberFormatException e) {
                String message = "Wrong enter. Try again";
                req.setAttribute("message", message);
                req.getRequestDispatcher("/view/findCustomer.jsp").forward(req, resp);
            }
        }
        else if (action.matches("/add")) {
            req.getRequestDispatcher("/view/addCustomerForm.jsp").forward(req, resp);
        }
        else if (action.matches("/update/form")) {
            req.getRequestDispatcher("/view/updateCustomerForm.jsp").forward(req, resp);
        }
        else if (action.matches("/delete/form")) {
            req.getRequestDispatcher("/view/deleteCustomerForm.jsp").forward(req, resp);
        }
        else if (action.startsWith("/delete")) {
            doDelete(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = getAction(req);

        if (action.matches("/add")) {
            String customerName = req.getParameter("customerName");
            String country = req.getParameter("country");
            String email = req.getParameter("email");
            CustomersDto customer = new CustomersDto(customerName, country, email);
            if (!customer.getCustomerName().isBlank() || !customer.getCountry().isBlank()
                    || !customer.getEmail().isBlank()) {
                CustomersDto savedCustomer = customersService.save(customer);
                req.setAttribute("savedCustomer", savedCustomer);
                req.setAttribute("message", "Customer added");
                req.getRequestDispatcher("/view/addCustomer.jsp").forward(req, resp);
            } else {
                req.setAttribute("message", "Customer not added");
                req.getRequestDispatcher("/view/addCustomer.jsp").forward(req, resp);
            }
        } else if (action.matches("/update")) {
            try {
                int customerId = Integer.parseInt(req.getParameter("customerId"));
                String customerName = req.getParameter("customerName");
                String country = req.getParameter("country");
                String email = req.getParameter("email");
                CustomersDto customer = new CustomersDto(customerId, customerName, country, email);
                if (!customer.getCustomerName().isBlank() || !customer.getCountry().isBlank()
                        || !customer.getEmail().isBlank()) {
                    CustomersDto updatedCompany = customersService.update(customer);
                    req.setAttribute("updatedCustomer", updatedCompany);
                    req.setAttribute("message", "Customer updated");
                    req.getRequestDispatcher("/view/updateCustomer.jsp").forward(req, resp);
                } else {
                    req.setAttribute("message", "Customer not updated");
                    req.getRequestDispatcher("/view/updateCustomer.jsp").forward(req, resp);
                }
            } catch (NumberFormatException e) {
                String message = "Wrong enter. Try again";
                req.setAttribute("message", message);
                req.getRequestDispatcher("/view/updateCustomer.jsp").forward(req, resp);
            }
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            int customerId = Integer.parseInt(req.getParameter("customerId"));
            CustomersDto customer = customersService.findById(customerId);
            String message;
            if (customer.equals(new CustomersDto())) {
                message = String.format("Customer with ID %s not found", customerId);
                req.setAttribute("message", message);
                req.getRequestDispatcher("/view/deleteCustomer.jsp").forward(req, resp);
            } else {
                message = String.format("Customer with ID %s deleted", customerId);
                req.setAttribute("customer", customer);
                req.setAttribute("message", message);
                customersService.delete(customer);
                req.getRequestDispatcher("/view/deleteCustomer.jsp").forward(req, resp);
            }
        } catch (NumberFormatException e) {
            String message = "Wrong enter. Try again";
            req.setAttribute("message", message);
            req.getRequestDispatcher("/view/deleteCustomer.jsp").forward(req, resp);
        }
    }

    private String getAction(HttpServletRequest req) {
        String requestURI = req.getRequestURI();
        String requestPathWithServletContext = req.getContextPath() + req.getServletPath();
        return requestURI.substring(requestPathWithServletContext.length());
    }
}
