package me.restaurant.interfaces;

import me.restaurant.application.MenuItemService;
import me.restaurant.domain.MenuItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MenuItemController {

    @Autowired
    MenuItemService menuItemService;

    @GetMapping("/restaurants/{restaurantId}/menuitems")
    public List<MenuItem> list(@PathVariable Long restaurantId) {
        List<MenuItem> menuItems = menuItemService.getMenuItems(restaurantId);

        return menuItems;
    }

    @PatchMapping("/restaurants/{restaurantId}/menuitems")
    public String bulkUpdate(
            @PathVariable("restaurantId") Long restaurantId,
            @RequestBody List<MenuItem> menuItems
    ) {
        menuItemService.bulkUpdate(restaurantId, menuItems);
        return "";
    }
}
