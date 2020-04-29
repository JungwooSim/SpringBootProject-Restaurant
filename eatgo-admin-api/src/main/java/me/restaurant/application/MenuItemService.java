package me.restaurant.application;

import me.restaurant.domain.MenuItem;
import me.restaurant.domain.MenuItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MenuItemService {
    MenuItemRepository menuItemRepository;

    @Autowired
    public MenuItemService(MenuItemRepository menuItemRepository) {
        this.menuItemRepository = menuItemRepository;
    }

    public void bulkUpdate(Long restaurantId, List<MenuItem> menuItems) {
        update(restaurantId, menuItems);
    }

    private void update(Long restaurantId, List<MenuItem> menuItems) {
        for (MenuItem menuItem : menuItems) {
            if (menuItem.isDestory()) {
                menuItemRepository.deleteById(menuItem.getId());
                continue;
            }
            menuItem.setRestaurantId(restaurantId);
            menuItemRepository.save(menuItem);
        }
    }

    public List<MenuItem> getMenuItems(Long restaurantId) {
        return menuItemRepository.findAllByRestaurantId(restaurantId);
    }
}
