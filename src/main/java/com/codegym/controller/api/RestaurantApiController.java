package com.codegym.controller.api;

import com.codegym.entity.*;
import com.codegym.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


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
    @Autowired
    IBillService billService;
    @Autowired
    IReportService reportService;
    @Autowired
    INotificationService notificationService;

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


    @PostMapping ("/category/create")
    public Category createCategory (@RequestBody Category category) {
        Category categoryresp = categoryService.save(category);
        return categoryresp;
    }
    @GetMapping("/category/list")
    public Iterable<Category> getAllCategory () {
        return categoryService.findAll();
    }

    @GetMapping("/category/getbyid/{id}")
    private Optional<Category> getCategoryByIdget (Long id) {
        return categoryService.findById(id);
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


    @PostMapping ("/product/create")
    public Product createProduct (@RequestBody Product product) {
        return productService.save(product);
    }

    @GetMapping("/product/getproduct")
    public Iterable <Product> getAllProduct () {
        return productService.findAll();
    }
    @GetMapping ("/product/delete/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id) {
        productService.remove(id);

        Optional<Product> product = productService.findById(id);

        if (product.isPresent()) {
            return new ResponseEntity<Boolean>(false, HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<Boolean>(true, HttpStatus.CREATED);
    }
    @GetMapping("/product/getprice/{id}")
    public Product getPriceProduct (@PathVariable Long id) {
        return productService.findById(id).get();
    }


    @PostMapping ("/orderdetail/create")
    public OrderDetail createOrderDetail (@RequestBody OrderDetail orderDetail) {
        return orderDetailService.save(orderDetail);
    }

    @GetMapping ("/orderdetail/getall")
    public Iterable <OrderDetail> getAll () {
        return orderDetailService.findAll();
    }


    @PostMapping("/bill/create")
    public Bill createBill (@RequestBody Bill bill) {
        return billService.save(bill);
    }

    @GetMapping("/bill/getall")
    public Iterable <Bill> getABill () {
        return billService.findAll();
    }

    @PostMapping ("/report/create")
    public Report createReport (@RequestBody Report report) {
        return reportService.save(report);
    }

    @GetMapping("/report/getall")
    public Iterable<Report> getAllReport () {
       return reportService.findAll();
    }

    @PostMapping ("/notification/create")
    public Notification createNotification (@RequestBody Notification notification) {
        return notificationService.save(notification);
    }

    @GetMapping("/notification/getnotification")
    public Iterable <Notification> getNotification () {
        return notificationService.findAll();
    }

}
