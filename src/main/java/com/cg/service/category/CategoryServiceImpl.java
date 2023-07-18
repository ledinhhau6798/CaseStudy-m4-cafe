package com.cg.service.category;

import com.cg.model.Category;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements ICategoryService{
    @Override
    public List<Category> findAll() {
        return null;
    }

    @Override
    public Optional<Category> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Category save(Category category) {
        return null;
    }

    @Override
    public void delete(Category category) {

    }

    @Override
    public void deleteById(Long id) {

    }
}
