package me.restaurant.application;

import me.restaurant.domain.Category;
import me.restaurant.domain.CategoryRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

public class CategoryServiceTests {
    CategoryService categoryService;

    @Mock
    CategoryRepository categoryRepository;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        categoryService = new CategoryService(categoryRepository);
    }

    @Test
    public void getRegions() {
        List<Category> MockCategories = new ArrayList<>();
        MockCategories.add(Category.builder().name("Korean Food").build());

        given(categoryRepository.findAll()).willReturn(MockCategories);

        List<Category> categories = categoryService.getCategories();

        Category category = categories.get(0);
        assertThat(category.getName(), is("Korean Food"));
    }

    @Test
    public void addRegions() {
        Category category = categoryService.addCategory("Korean Food");

        verify(categoryRepository).save(any());
        assertThat(category.getName(), is("Korean Food"));
    }
}
