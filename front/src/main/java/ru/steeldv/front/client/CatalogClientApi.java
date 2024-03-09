package ru.steeldv.front.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import ru.steeldv.front.model.catalog.Category;
import ru.steeldv.front.model.catalog.Item;
import ru.steeldv.front.model.catalog.Product;
import ru.steeldv.front.model.catalog.Subcategory;

import java.util.List;

@FeignClient(name = "catalog")
public interface CatalogClientApi {

    //    region category
    @GetMapping("/category/findAll")
    public List<Category> findAllCategories();

    @PostMapping("/category/addCategory")
    public Category addCategory(@RequestBody Category category);

    @PutMapping("/category/update/{id}")
    public Category updateCategory(@RequestBody Category category, @PathVariable Long id);

    @DeleteMapping("/category/delete/{id}")
    public boolean deleteCategory(@PathVariable Long id);
//    endregion category

    //    region subcategory
    @PostMapping("/subcategory/addSubcategory")
    public Subcategory addSubcategory(@RequestBody Subcategory subcategory);

    @PutMapping("/subcategory/update/{id}")
    public Subcategory updateSubcategory(@RequestBody Subcategory subcategory, @PathVariable Long id);

    @DeleteMapping("/subcategory/delete/{id}")
    public boolean deleteSubcategory(@PathVariable Long id);

    @GetMapping("/subcategory/findByCategoryId/{id}")
    public List<Subcategory> findSubcategoryByCategoryId(@PathVariable Long id);
//    endregion subcategory

    //    region product
    @PostMapping("/product/addProduct")
    public Product addProduct(@RequestBody Product product);

    @PutMapping("/product/update/{id}")
    public Product updateProduct(@RequestBody Product product, @PathVariable Long id);

    @DeleteMapping("/product/delete/{id}")
    public boolean deleteProduct(@PathVariable Long id);

    @GetMapping("/product/findByCategoryId/{id}")
    public List<Product> findProductByCategoryId(@PathVariable Long id);

    @GetMapping("/product/findBySubcategoryId/{id}")
    public List<Product> findProductBySubcategoryId(@PathVariable Long id);
//    endregion product

    //    region item
    @GetMapping("/item/findAll")
    public List<Item> findAllItems();

    @PostMapping("/item/addItem")
    public Item addItem(@RequestBody Item item);

    @PutMapping("/item/update/{id}")
    public Item updateItem(@RequestBody Item item, @PathVariable Long id);

    @DeleteMapping("/item/delete/{id}")
    public boolean deleteItem(@PathVariable Long id);

    @GetMapping("/item/findItem/{id}")
    public Item findItem(@PathVariable Long id);

    @GetMapping("/item/findByProductId/{id}")
    public List<Item> findItemByProductId(@PathVariable Long id);
//    endregion item

}
