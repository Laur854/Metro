package com.github.ngoanh2n.scenarios;

import com.github.ngoanh2n.common.BaseTest;
import org.testng.annotations.Test;

/**
 * ExampleTest class
 * <br/>
 *
 * @author ngoanh2n@gmail.com (Ho Huu Ngoan)
 */

public class Tests extends BaseTest {

    @Test(priority = 1, description = "successfully add two products to cart and assert that the operation is successful")
    void addTwoProducts(){
        this.homePage

                .verifyHomePageEmpty()
                .acceptCookies()

                //Handle first product
                .reachFirstProductPage()
                .clickAddProductButton()
                .closeProductsWindow()
                .returnToHomepage()

                //Handle second product
                .reachSecondProductPage()
                .clickAddProductButton();


    }

    @Test(priority = 2, description = "remove successfully one of them and assert that the result is correct")
    void removeFirstProduct(){
        this.homePage

                .verifyHomePageEmpty()
                .acceptCookies()

                //Handle first product
                .reachFirstProductPage()
                .clickAddProductButton()
                .closeProductsWindow()
                .returnToHomepage()

                //Handle second product
                .reachSecondProductPage()
                .clickAddProductButton()
                .closeProductsWindow()
                .returnToHomepage()

                //Handle cart
                .openCart()
                .deleteFirstProductAndAssert();

    }

    @Test(priority = 3, description = "remove successfully the remaining one and assert that the result is correct")
    void removeSecondProduct(){
        this.homePage

                .verifyHomePageEmpty()
                .acceptCookies()

                //Handle first product
                .reachFirstProductPage()
                .clickAddProductButton()
                .closeProductsWindow()
                .returnToHomepage()

                //Handle second product
                .reachSecondProductPage()
                .clickAddProductButton()
                .closeProductsWindow()
                .returnToHomepage()

                //Handle cart
                .openCart()
                .deleteFirstProductAndAssert()
                .deleteSecondProduct();

    }

    @Test(priority = 4, description = "try to remove again one of the products expecting a failed test in this case")
    void expectFailed() {
        this.homePage

                .verifyHomePageEmpty()
                .acceptCookies()

                //Handle first product
                .reachFirstProductPage()
                .clickAddProductButton()
                .closeProductsWindow()
                .returnToHomepage()

                //Handle second product
                .reachSecondProductPage()
                .clickAddProductButton()
                .closeProductsWindow()
                .returnToHomepage()

                //Handle cart
                .openCart()
                .deleteFirstProductAndAssert()
                .deleteFirstProduct()

                //Expected failed test
                .deleteFirstProduct();
    }


}
