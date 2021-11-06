package com.codegym.controller.api;

import com.codegym.entity.*;
import com.codegym.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;

import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
@PropertySource("classpath:upload_file.properties")
public class RestaurantApiController {
    @Value("${file}")
    private String fileUpload;

    @Value("${tomcat_folder}")
    private String tomcatUpload;
    @Autowired
    IStaffService staffService;
    @Autowired
    IRoleService roleService;
    @Autowired
    ICategoryService categoryService;
    @Autowired
    IProductService productService;
    @Autowired
    ITableService tableService;
    @Autowired
    IOrderDetailService orderDetailService;

    @PostMapping("/create")
    public Staff crateUser (@RequestBody Staff staff) {
        System.out.println(staff);
        Role role = roleService.save(staff.getRole());
        System.out.println(role);
        staff.setRole(role);
        return  staffService.save(staff);
    }

    @PostMapping("/login")
    public boolean login (@RequestBody Login login) {
        boolean checkAcount = false;
        Iterable<Staff> staffList = staffService.findAll();
        for(Staff staff : staffList) {
            if (login.getUserName().equals(staff.getUserName())){
                if(login.getPassword().equals(staff.getPassword())){
                    checkAcount = true;
                    break;
                }else {
                   checkAcount = false;
                }
            }else {
                checkAcount = false;
            }
        }
        if(checkAcount){
            return true;
        }else {
            return false;
        }
    }

    @PostMapping ("/product/create")
    public Product createProduct (@RequestBody Product product) {
            return productService.save(product);
    }

    @PostMapping ("/category/create")
    public Category createCategory (@RequestBody Category category) {
        Category categoryresp = categoryService.save(category);
        return categoryresp;
    }

    @GetMapping("/category/list")
    public Iterable<Category> getAllCategory () {
        return categoryService.findAll();
    }

    @PostMapping ("/table/create")
    public TableDinner createTable (@RequestBody TableDinner tableDinner) {
        return tableService.save(tableDinner);
    }

    @GetMapping ("/table/gettable")
    public Iterable <TableDinner> getAllTable () {
        return tableService.findAll();
    }

    @GetMapping ("/table/gettable/{id}")
    public TableDinner getTableByid (@PathVariable Long id) {
        return tableService.findById(id).get();
    }


    @GetMapping("/product/getproduct")
    public Iterable <Product> getAllProduct () {
        return productService.findAll();
    }



    @GetMapping("/product/getprice/{id}")
    public Product getPriceProduct (@PathVariable Long id) {
        return productService.findById(id).get();
    }

    @PostMapping ("/orderdetail/create")
    public OrderDetail createOrderDetail (@RequestBody OrderDetail orderDetail) {
        return orderDetailService.save(orderDetail);
    }
//
//    @GetMapping("/orderdetail/gettableby/${id}")
//    public Iterable<OrderDetail> getOrderDetails (@PathVariable Long id) {
//        return orderDetailService.findAllByTableId(id);
//    }

    @GetMapping ("/orderdetail/getall")
    public Iterable <OrderDetail> getAll () {
        return orderDetailService.findAll();
    }



}
