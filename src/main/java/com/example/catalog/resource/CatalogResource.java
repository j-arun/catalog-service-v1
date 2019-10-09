package com.example.catalog.resource;

import com.example.catalog.entity.Product;
import com.example.catalog.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.util.List;



@Api(
value = "Product",
produces = "application/json")
@RestController
@RequestMapping("/catalog")
public class CatalogResource{

	private Logger logger = LoggerFactory.getLogger(CatalogResource.class);

    @Autowired
    private CatalogService service;

    @RequestMapping(method = RequestMethod.POST ,value="add")
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "adds the given product to catalog", notes = "Adds products to catalog")
    @ApiResponses(value=
            {@ApiResponse(code = 500,message = "Fields are with validation errors"),
            @ApiResponse(code = 400, message = "Error occurred while processing request")}
            )
    public  ResponseEntity<String> addProduct(@ApiParam(value = "Product added to catalog")
    @RequestBody Product product) {
        logger.debug("Entered add() >>"+product);
        long id =  service.addProduct(product);
        logger.info("Product added to catalog : id :"+id);
        logger.debug("Exited add() >>"+product);
        return new ResponseEntity<String>("Created :"+id, HttpStatus.CREATED);
    }

    @RequestMapping(method= RequestMethod.GET,value="getall" )
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "list products in catalog", notes = "lists  all product in the catalog with state, regoin code and availablity status")
    public  List<Product> getAllProducts() {
    	  logger.debug("Entered getAllProducts >>");
          return service.getAllProducts();
    }


    @DeleteMapping("/delete/{productId}")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "delete the given product from catalog", notes = "Delete  products from catalog")
    @ApiResponses(value=
            {@ApiResponse(code = 500,message = "Fields are with validation errors"),
                    @ApiResponse(code = 400, message = "Error occurred while processing request")}
    )
    public  ResponseEntity<String> delete(@ApiParam(value = "delete  product from catalog")
                                              @PathVariable long productId) {
        logger.debug("Entered delete() >>"+productId);
        long id = service.deleteProduct(productId);
        logger.debug("Exited delete() >>"+productId);
        return new ResponseEntity<String>("deleted :"+ id, HttpStatus.OK);
    }
}
