package ru.steeldv.front.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.steeldv.front.service.catalog.CategoryService;
import ru.steeldv.front.service.catalog.ItemService;
import ru.steeldv.front.service.catalog.ProductService;
import ru.steeldv.front.service.catalog.SubcategoryService;
import ru.steeldv.library.api.CatalogApi;
import ru.steeldv.library.model.dto.catalog.Category;
import ru.steeldv.library.model.dto.catalog.Item;
import ru.steeldv.library.model.dto.catalog.Product;
import ru.steeldv.library.model.dto.catalog.Subcategory;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CatalogServiceImpl implements CategoryService, SubcategoryService, ProductService, ItemService {
    private final CatalogApi catalogApi;

    //    region category
    public List<Category> findAllCategories() {
        return catalogApi.findAllCategories();
    }

    public Category addCategory(Category category) {
        return catalogApi.addCategory(category);
    }

    public Category updateCategory(Category category, Long id) {
        return catalogApi.updateCategory(category, id);
    }

    public void deleteCategory(Long id) {
        catalogApi.deleteCategory(id);
    }
//    endregion category

    //    region subcategory
    public Subcategory addSubcategory(Subcategory subcategory) {
        return catalogApi.addSubcategory(subcategory);
    }

    public Subcategory updateSubcategory(Subcategory subcategory, Long id) {
        return catalogApi.updateSubcategory(subcategory, id);
    }

    public void deleteSubcategory(Long id) {
        catalogApi.deleteSubcategory(id);
    }

    public List<Subcategory> findSubcategoryByCategoryId(Long id) {
        return catalogApi.findSubcategoryByCategoryId(id);
    }

//    endregion subcategory

    //    region product
    public Product addProduct(Product product) {
        return catalogApi.addProduct(product);
    }

    public Product updateProduct(Product product, Long id) {
        return catalogApi.updateProduct(product, id);
    }

    public void deleteProduct(Long id) {
        catalogApi.deleteProduct(id);
    }

    public List<Product> findProductByCategoryId(Long id) {
        return catalogApi.findProductByCategoryId(id);
    }

    public List<Product> findProductBySubcategoryId(Long id) {
        return catalogApi.findProductBySubcategoryId(id);
    }
//    endregion product

    //    region item
    public List<Item> findAllItems(){
        return catalogApi.findAllItems();
    }

    public Item addItem(Item item){
        return catalogApi.addItem(item);
    }

    public Item updateItem(Item item, Long id){
        return catalogApi.updateItem(item, id);
    }

    public void deleteItem(Long id){
        catalogApi.deleteItem(id);
    }

    public Item findItem(Long id){
        return catalogApi.findItem(id);
    }

    public List<Item> findItemByProductId(Long id){
        return catalogApi.findItemByProductId(id);
    }
//    endregion item
}
