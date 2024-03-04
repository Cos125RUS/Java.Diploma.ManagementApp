package ru.steeldv.front.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import ru.steeldv.front.client.CatalogClientApi;
import ru.steeldv.front.model.Category;
import ru.steeldv.front.model.Item;
import ru.steeldv.front.model.Product;
import ru.steeldv.front.model.Subcategory;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CatalogService {
    private final CatalogClientApi catalogClientApi;

    //    region category
    public List<Category> findAllCategories() {
        return catalogClientApi.findAllCategories();
    }

    public Category addCategory(Category category) {
        return catalogClientApi.addCategory(category);
    }

    public Category updateCategory(Category category, Long id) {
        return catalogClientApi.updateCategory(category, id);
    }

    public boolean deleteCategory(Long id) {
        return catalogClientApi.deleteCategory(id);
    }
//    endregion category

    //    region subcategory
    public Subcategory addSubcategory(Subcategory subcategory) {
        return catalogClientApi.addSubcategory(subcategory);
    }

    public Subcategory updateSubcategory(Subcategory subcategory, Long id) {
        return catalogClientApi.updateSubcategory(subcategory, id);
    }

    public boolean deleteSubcategory(Long id) {
        return catalogClientApi.deleteSubcategory(id);
    }

    public List<Subcategory> findSubcategoryByCategoryId(Long id) {
        return catalogClientApi.findSubcategoryByCategoryId(id);
    }

//    endregion subcategory

    //    region product
    public Product addProduct(Product product) {
        return catalogClientApi.addProduct(product);
    }

    public Product updateProduct(Product product, Long id) {
        return catalogClientApi.updateProduct(product, id);
    }

    public boolean deleteProduct(Long id) {
        return catalogClientApi.deleteProduct(id);
    }

    public List<Product> findProductByCategoryId(Long id) {
        return catalogClientApi.findProductByCategoryId(id);
    }

    public List<Product> findProductBySubcategoryId(Long id) {
        return catalogClientApi.findProductBySubcategoryId(id);
    }
//    endregion product

    //    region item
    public List<Item> findAllItems(){
        return catalogClientApi.findAllItems();
    }

    public Item addItem(Item item){
        return catalogClientApi.addItem(item);
    }

    public Item updateItem(Item item, Long id){
        return catalogClientApi.updateItem(item, id);
    }

    public boolean deleteItem(Long id){
        return catalogClientApi.deleteItem(id);
    }

    public Item findItem(Long id){
        return catalogClientApi.findItem(id);
    }

    public List<Item> findItemByProductId(Long id){
        return catalogClientApi.findItemByProductId(id);
    }
//    endregion item
}
