package com.camilo.mall.domain;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class Mall {
    public static final byte CAPACITY = 100;
    private String name;
    private List<Store> stores;

    public Mall(String name) {
        this.name = name;
        this.stores = new ArrayList<>();
    }

    public boolean openStore(Store store) {
        Store storeToOpen = searchStoreByName(store.getName());
        if(storeToOpen == null && this.stores.size()+1 < CAPACITY){
            this.stores.add(store);
            System.out.println("Store add successful");
            return true;
        }
        System.out.println("the store already exist");
        return false;
    }

    public void closeStoreForCode(long code) {
        Store storeToClose = searchStoreByCode(code);
        if(storeToClose != null){
            this.stores.remove(storeToClose);
        }
        else{
            System.out.println("Can not has been the store");
        }

    }

    public Store searchStoreByName(String name) {
        return this.stores.stream().filter(st->st.getName().
                equals(name)).findFirst().
                orElse(null);
    }

    public Store searchStoreByCode(long code) {
        Store storeToSearch = null;
        for (Store st : this.stores){
            if(st.getCode() == code){
                storeToSearch = st;
                break;
            }
        }
        return storeToSearch;
    }

    public List<Store> searchStoreForDeterminateCategory(String category) {
        List<Store>  storesForCategory = new ArrayList<>();
        for (Store st: this.stores){
            if(st.getCategories().stream().
                    filter(ct->ct.getName().equals(category)).findFirst().orElse(null) != null){
                storesForCategory.add(st);
            }
        }
        return storesForCategory;
    }

    public List<Store> getStoreWithTwoMoreTheTwoCategories() {
        return this.stores.stream().
        filter(st->st.getCategories().size() > 1).
                collect(Collectors.toList());
    }

    public void sortedStoresByName() {
        this.stores.sort(Comparator.comparing(Store::getName));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Store> getStores() {
        return stores;
    }
}
