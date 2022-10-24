package ua.goit.homeworkhibernate.service;

import ua.goit.homeworkhibernate.model.dao.CustomersDao;
import ua.goit.homeworkhibernate.model.dto.CustomersDto;
import ua.goit.homeworkhibernate.repository.CustomersRepository;
import ua.goit.homeworkhibernate.service.convert.CustomersConverter;

import java.util.ArrayList;
import java.util.List;

public class CustomersService implements Service<CustomersDto> {
    private final CustomersRepository customersRepository;
    private final CustomersConverter customersConverter;

    public CustomersService(CustomersRepository customersRepository, CustomersConverter customersConverter) {
        this.customersRepository = customersRepository;
        this.customersConverter = customersConverter;
    }

    @Override
    public CustomersDto save(CustomersDto entity) {
        CustomersDao savedCustomer = customersRepository.save(customersConverter.to(entity));
        return customersConverter.from(savedCustomer);
    }

    @Override
    public CustomersDto update(CustomersDto entity) {
        CustomersDao updatedCustomer = customersRepository.update(customersConverter.to(entity));
        return customersConverter.from(updatedCustomer);
    }

    @Override
    public void delete(CustomersDto entity) {
        customersRepository.delete(customersConverter.to(entity));
    }

    @Override
    public CustomersDto findById(Integer id) {
        CustomersDao byId = customersRepository.findById(id);
        return customersConverter.from(byId);
    }

    @Override
    public List<CustomersDto> findAll() {
        List<CustomersDto> customersDtoList = new ArrayList<>();
        List<CustomersDao> customersDaoList = customersRepository.findAll();
        for (CustomersDao dao: customersDaoList) {
            customersDtoList.add(customersConverter.from(dao));
        }
        return customersDtoList;
    }
}
