package com.bitly;

import commons.BaseTest;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.bitly.HomePageObject;
import pageObjects.bitly.LandingPageObject;
import pageObjects.bitly.PageGeneratorManager;
import pageObjects.bitly.SignInPageObject;

import java.util.Random;

public class Create_ShortLink extends BaseTest {
    WebDriver driver;
    LandingPageObject landingPage;
    HomePageObject homePage;
    SignInPageObject signInPage;
    String[]results={};
    @Parameters({"browser","url"})
    @BeforeClass
    public void beforeClass(String browserName, String url){
        driver= getBrowserDriver(browserName);
        driver.get(url);
        driver.manage().window().maximize();
        landingPage= PageGeneratorManager.getLandingPage(driver);
        signInPage=landingPage.clickToLoginLink();
        signInPage.enterEmail("qcgosell02@gmail.com");
        signInPage.enterPass("Psso1234");
        homePage= signInPage.clickToLoginButon();
    }

    @Test(dataProvider="LongLink")
    public void CreateShortLink(String longLink){
        homePage.clickCreateButon();
        homePage.enterLongLink(longLink);
        homePage.enterSource(RandomStringUtils.randomAlphanumeric(6));
        homePage.clickToCreatSubmit();
        String shortLink= homePage.getShortLink();
        System.out.println('\"'+shortLink+'\"'+',');
        homePage.clickCloseIcon();
    }
    @DataProvider(name="LongLink")
    public Object[] getDataFromDataprovider(){
        return new Object[]
                {
                        "https://gafa.vn/wp-content/uploads/2019/12/gi%C3%A0y-g%C3%B3t-trong-su%E1%BB%91t-8cm-3.jpg",
                        "https://gafa.vn/wp-content/uploads/2019/11/dsc_5082-768x768.jpg",
                        "https://gafa.vn/wp-content/uploads/2019/11/dsc_5082-768x768.jpg",
                        "https://gafa.vn/wp-content/uploads/2018/12/1-26-768x960.jpg",
                        "https://gafa.vn/wp-content/uploads/2018/12/Ziggy3.jpg",
                        "https://vn-test-11.slatic.net/p/30463f330b1b0e76a8c2f96e41f4cbe7.jpg_814x814Q100.jpg",
                        "https://salt.tikicdn.com/ts/product/8c/83/bd/4e581e89d5325f95230171c5cc72e454.jpg",
                        "https://media3.scdn.vn/img4/2020/10_18/MnESRQeq04hno5Q4Z1oQ_simg_b5529c_250x250_maxb.jpg",
                        "https://media3.scdn.vn/img3/2019/4_13/lmrmy5_simg_b5529c_250x250_maxb.jpg",
                        "https://media3.scdn.vn/img2/2018/7_30/sK6axV_simg_b5529c_250x250_maxb.jpg",
                        "https://media3.scdn.vn/img3/2019/10_14/t4tyjy_simg_b5529c_250x250_maxb.jpg",
                        "https://media3.scdn.vn/img3/2019/10_14/t4tyjy_simg_b5529c_250x250_maxb.jpg",
                        "https://media3.scdn.vn/img3/2019/3_7/CYu9xf_simg_b5529c_250x250_maxb.jpg",
                        "https://media3.scdn.vn/img3/2019/1_1/eC549t_simg_b5529c_250x250_maxb.jpg",
                        "https://media3.scdn.vn/img3/2019/7_23/29n4Mg_simg_b5529c_250x250_maxb.jpg",
                        "https://media3.scdn.vn/img2/2018/8_19/38HxoQ_simg_b5529c_250x250_maxb.jpg",
                        "https://media3.scdn.vn/img4/2020/06_22/Nk5ykGj71HfAyyGkUXPt_simg_b5529c_250x250_maxb.jpg",
                        "https://media3.scdn.vn/img3/2019/11_6/w3m1oi_simg_b5529c_250x250_maxb.jpg",
                        "https://gafa.vn/wp-content/uploads/2019/12/gi%C3%A0y-g%C3%B3t-trong-su%E1%BB%91t-8cm-3.jpg",
                        "https://gafa.vn/wp-content/uploads/2019/11/dsc_5082-768x768.jpg",
                        "https://gafa.vn/wp-content/uploads/2019/11/dsc_5082-768x768.jpg",
                        "https://gafa.vn/wp-content/uploads/2018/12/1-26-768x960.jpg",
                        "https://gafa.vn/wp-content/uploads/2018/12/Ziggy3.jpg",
                        "https://vn-test-11.slatic.net/p/30463f330b1b0e76a8c2f96e41f4cbe7.jpg_814x814Q100.jpg",
                        "https://salt.tikicdn.com/ts/product/8c/83/bd/4e581e89d5325f95230171c5cc72e454.jpg",
                        "https://media3.scdn.vn/img4/2020/10_18/MnESRQeq04hno5Q4Z1oQ_simg_b5529c_250x250_maxb.jpg",
                        "https://media3.scdn.vn/img3/2019/4_13/lmrmy5_simg_b5529c_250x250_maxb.jpg",
                        "https://media3.scdn.vn/img2/2018/7_30/sK6axV_simg_b5529c_250x250_maxb.jpg",
                        "https://media3.scdn.vn/img3/2019/10_14/t4tyjy_simg_b5529c_250x250_maxb.jpg",
                        "https://media3.scdn.vn/img3/2019/10_14/t4tyjy_simg_b5529c_250x250_maxb.jpg",
                        "https://media3.scdn.vn/img3/2019/3_7/CYu9xf_simg_b5529c_250x250_maxb.jpg",
                        "https://media3.scdn.vn/img3/2019/1_1/eC549t_simg_b5529c_250x250_maxb.jpg",
                        "https://media3.scdn.vn/img3/2019/7_23/29n4Mg_simg_b5529c_250x250_maxb.jpg",
                        "https://media3.scdn.vn/img2/2018/8_19/38HxoQ_simg_b5529c_250x250_maxb.jpg",
                        "https://media3.scdn.vn/img4/2020/06_22/Nk5ykGj71HfAyyGkUXPt_simg_b5529c_250x250_maxb.jpg",
                        "https://media3.scdn.vn/img3/2019/11_6/w3m1oi_simg_b5529c_250x250_maxb.jpg",
                        "https://gafa.vn/wp-content/uploads/2019/12/gi%C3%A0y-g%C3%B3t-trong-su%E1%BB%91t-8cm-3.jpg",
                        "https://gafa.vn/wp-content/uploads/2019/11/dsc_5082-768x768.jpg",
                        "https://gafa.vn/wp-content/uploads/2019/11/dsc_5082-768x768.jpg",
                        "https://gafa.vn/wp-content/uploads/2018/12/1-26-768x960.jpg",
                        "https://gafa.vn/wp-content/uploads/2018/12/Ziggy3.jpg",
                        "https://vn-test-11.slatic.net/p/30463f330b1b0e76a8c2f96e41f4cbe7.jpg_814x814Q100.jpg",
                        "https://salt.tikicdn.com/ts/product/8c/83/bd/4e581e89d5325f95230171c5cc72e454.jpg",
                        "https://media3.scdn.vn/img4/2020/10_18/MnESRQeq04hno5Q4Z1oQ_simg_b5529c_250x250_maxb.jpg",
                        "https://media3.scdn.vn/img3/2019/4_13/lmrmy5_simg_b5529c_250x250_maxb.jpg",
                        "https://media3.scdn.vn/img2/2018/7_30/sK6axV_simg_b5529c_250x250_maxb.jpg",
                        "https://media3.scdn.vn/img3/2019/10_14/t4tyjy_simg_b5529c_250x250_maxb.jpg",
                        "https://media3.scdn.vn/img3/2019/10_14/t4tyjy_simg_b5529c_250x250_maxb.jpg",
                        "https://media3.scdn.vn/img3/2019/3_7/CYu9xf_simg_b5529c_250x250_maxb.jpg",
                        "https://media3.scdn.vn/img3/2019/1_1/eC549t_simg_b5529c_250x250_maxb.jpg",
                        "https://media3.scdn.vn/img3/2019/7_23/29n4Mg_simg_b5529c_250x250_maxb.jpg",
                        "https://media3.scdn.vn/img2/2018/8_19/38HxoQ_simg_b5529c_250x250_maxb.jpg",
                        "https://media3.scdn.vn/img4/2020/06_22/Nk5ykGj71HfAyyGkUXPt_simg_b5529c_250x250_maxb.jpg",
                        "https://media3.scdn.vn/img3/2019/11_6/w3m1oi_simg_b5529c_250x250_maxb.jpg",
                        "https://gafa.vn/wp-content/uploads/2019/12/gi%C3%A0y-g%C3%B3t-trong-su%E1%BB%91t-8cm-3.jpg",
                        "https://gafa.vn/wp-content/uploads/2019/11/dsc_5082-768x768.jpg",
                        "https://gafa.vn/wp-content/uploads/2019/11/dsc_5082-768x768.jpg",
                        "https://gafa.vn/wp-content/uploads/2018/12/1-26-768x960.jpg",
                        "https://gafa.vn/wp-content/uploads/2018/12/Ziggy3.jpg",
                        "https://vn-test-11.slatic.net/p/30463f330b1b0e76a8c2f96e41f4cbe7.jpg_814x814Q100.jpg",
                        "https://salt.tikicdn.com/ts/product/8c/83/bd/4e581e89d5325f95230171c5cc72e454.jpg",
                        "https://media3.scdn.vn/img4/2020/10_18/MnESRQeq04hno5Q4Z1oQ_simg_b5529c_250x250_maxb.jpg",
                        "https://media3.scdn.vn/img3/2019/4_13/lmrmy5_simg_b5529c_250x250_maxb.jpg",
                        "https://media3.scdn.vn/img2/2018/7_30/sK6axV_simg_b5529c_250x250_maxb.jpg",
                        "https://media3.scdn.vn/img3/2019/10_14/t4tyjy_simg_b5529c_250x250_maxb.jpg",
                        "https://media3.scdn.vn/img3/2019/10_14/t4tyjy_simg_b5529c_250x250_maxb.jpg",
                        "https://media3.scdn.vn/img3/2019/3_7/CYu9xf_simg_b5529c_250x250_maxb.jpg",
                        "https://media3.scdn.vn/img3/2019/1_1/eC549t_simg_b5529c_250x250_maxb.jpg",
                        "https://media3.scdn.vn/img3/2019/7_23/29n4Mg_simg_b5529c_250x250_maxb.jpg",
                        "https://media3.scdn.vn/img2/2018/8_19/38HxoQ_simg_b5529c_250x250_maxb.jpg",
                        "https://media3.scdn.vn/img4/2020/06_22/Nk5ykGj71HfAyyGkUXPt_simg_b5529c_250x250_maxb.jpg",
                        "https://media3.scdn.vn/img3/2019/11_6/w3m1oi_simg_b5529c_250x250_maxb.jpg",
                        "https://gafa.vn/wp-content/uploads/2019/12/gi%C3%A0y-g%C3%B3t-trong-su%E1%BB%91t-8cm-3.jpg",
                        "https://gafa.vn/wp-content/uploads/2019/11/dsc_5082-768x768.jpg",
                        "https://gafa.vn/wp-content/uploads/2019/11/dsc_5082-768x768.jpg",
                        "https://gafa.vn/wp-content/uploads/2018/12/1-26-768x960.jpg",
                        "https://gafa.vn/wp-content/uploads/2018/12/Ziggy3.jpg",
                        "https://vn-test-11.slatic.net/p/30463f330b1b0e76a8c2f96e41f4cbe7.jpg_814x814Q100.jpg",
                        "https://salt.tikicdn.com/ts/product/8c/83/bd/4e581e89d5325f95230171c5cc72e454.jpg",
                        "https://media3.scdn.vn/img4/2020/10_18/MnESRQeq04hno5Q4Z1oQ_simg_b5529c_250x250_maxb.jpg",
                        "https://media3.scdn.vn/img3/2019/4_13/lmrmy5_simg_b5529c_250x250_maxb.jpg",
                        "https://media3.scdn.vn/img2/2018/7_30/sK6axV_simg_b5529c_250x250_maxb.jpg",
                        "https://media3.scdn.vn/img3/2019/10_14/t4tyjy_simg_b5529c_250x250_maxb.jpg",
                        "https://media3.scdn.vn/img3/2019/10_14/t4tyjy_simg_b5529c_250x250_maxb.jpg",
                        "https://media3.scdn.vn/img3/2019/3_7/CYu9xf_simg_b5529c_250x250_maxb.jpg",
                        "https://media3.scdn.vn/img3/2019/1_1/eC549t_simg_b5529c_250x250_maxb.jpg",
                        "https://media3.scdn.vn/img3/2019/7_23/29n4Mg_simg_b5529c_250x250_maxb.jpg",
                        "https://media3.scdn.vn/img2/2018/8_19/38HxoQ_simg_b5529c_250x250_maxb.jpg",
                        "https://media3.scdn.vn/img4/2020/06_22/Nk5ykGj71HfAyyGkUXPt_simg_b5529c_250x250_maxb.jpg",
                        "https://media3.scdn.vn/img3/2019/11_6/w3m1oi_simg_b5529c_250x250_maxb.jpg",
                        "https://gafa.vn/wp-content/uploads/2019/12/gi%C3%A0y-g%C3%B3t-trong-su%E1%BB%91t-8cm-3.jpg",
                        "https://gafa.vn/wp-content/uploads/2019/11/dsc_5082-768x768.jpg",
                        "https://gafa.vn/wp-content/uploads/2019/11/dsc_5082-768x768.jpg",
                        "https://gafa.vn/wp-content/uploads/2018/12/1-26-768x960.jpg",
                        "https://gafa.vn/wp-content/uploads/2018/12/Ziggy3.jpg",
                        "https://vn-test-11.slatic.net/p/30463f330b1b0e76a8c2f96e41f4cbe7.jpg_814x814Q100.jpg",
                        "https://salt.tikicdn.com/ts/product/8c/83/bd/4e581e89d5325f95230171c5cc72e454.jpg",
                        "https://media3.scdn.vn/img4/2020/10_18/MnESRQeq04hno5Q4Z1oQ_simg_b5529c_250x250_maxb.jpg",
                        "https://media3.scdn.vn/img3/2019/4_13/lmrmy5_simg_b5529c_250x250_maxb.jpg",
                        "https://media3.scdn.vn/img2/2018/7_30/sK6axV_simg_b5529c_250x250_maxb.jpg",
                        "https://media3.scdn.vn/img3/2019/10_14/t4tyjy_simg_b5529c_250x250_maxb.jpg",
                        "https://media3.scdn.vn/img3/2019/10_14/t4tyjy_simg_b5529c_250x250_maxb.jpg",
                        "https://media3.scdn.vn/img3/2019/3_7/CYu9xf_simg_b5529c_250x250_maxb.jpg",
                        "https://media3.scdn.vn/img3/2019/1_1/eC549t_simg_b5529c_250x250_maxb.jpg",
                        "https://media3.scdn.vn/img3/2019/7_23/29n4Mg_simg_b5529c_250x250_maxb.jpg",
                        "https://media3.scdn.vn/img2/2018/8_19/38HxoQ_simg_b5529c_250x250_maxb.jpg",
                        "https://media3.scdn.vn/img4/2020/06_22/Nk5ykGj71HfAyyGkUXPt_simg_b5529c_250x250_maxb.jpg",
                        "https://media3.scdn.vn/img3/2019/11_6/w3m1oi_simg_b5529c_250x250_maxb.jpg",
                        "https://gafa.vn/wp-content/uploads/2019/12/gi%C3%A0y-g%C3%B3t-trong-su%E1%BB%91t-8cm-3.jpg",
                        "https://gafa.vn/wp-content/uploads/2019/11/dsc_5082-768x768.jpg",
                        "https://gafa.vn/wp-content/uploads/2019/11/dsc_5082-768x768.jpg",
                        "https://gafa.vn/wp-content/uploads/2018/12/1-26-768x960.jpg",
                        "https://gafa.vn/wp-content/uploads/2018/12/Ziggy3.jpg",
                        "https://vn-test-11.slatic.net/p/30463f330b1b0e76a8c2f96e41f4cbe7.jpg_814x814Q100.jpg",
                        "https://salt.tikicdn.com/ts/product/8c/83/bd/4e581e89d5325f95230171c5cc72e454.jpg",
                        "https://media3.scdn.vn/img4/2020/10_18/MnESRQeq04hno5Q4Z1oQ_simg_b5529c_250x250_maxb.jpg",
                        "https://media3.scdn.vn/img3/2019/4_13/lmrmy5_simg_b5529c_250x250_maxb.jpg",
                        "https://media3.scdn.vn/img2/2018/7_30/sK6axV_simg_b5529c_250x250_maxb.jpg",
                        "https://media3.scdn.vn/img3/2019/10_14/t4tyjy_simg_b5529c_250x250_maxb.jpg",
                        "https://media3.scdn.vn/img3/2019/10_14/t4tyjy_simg_b5529c_250x250_maxb.jpg",
                        "https://media3.scdn.vn/img3/2019/3_7/CYu9xf_simg_b5529c_250x250_maxb.jpg",
                        "https://media3.scdn.vn/img3/2019/1_1/eC549t_simg_b5529c_250x250_maxb.jpg",
                        "https://media3.scdn.vn/img3/2019/7_23/29n4Mg_simg_b5529c_250x250_maxb.jpg",
                        "https://media3.scdn.vn/img2/2018/8_19/38HxoQ_simg_b5529c_250x250_maxb.jpg",
                        "https://media3.scdn.vn/img4/2020/06_22/Nk5ykGj71HfAyyGkUXPt_simg_b5529c_250x250_maxb.jpg",
                        "https://media3.scdn.vn/img3/2019/11_6/w3m1oi_simg_b5529c_250x250_maxb.jpg",
                        "https://gafa.vn/wp-content/uploads/2019/12/gi%C3%A0y-g%C3%B3t-trong-su%E1%BB%91t-8cm-3.jpg",
                        "https://gafa.vn/wp-content/uploads/2019/11/dsc_5082-768x768.jpg",
                        "https://gafa.vn/wp-content/uploads/2019/11/dsc_5082-768x768.jpg",
                        "https://gafa.vn/wp-content/uploads/2018/12/1-26-768x960.jpg",
                        "https://gafa.vn/wp-content/uploads/2018/12/Ziggy3.jpg",
                        "https://vn-test-11.slatic.net/p/30463f330b1b0e76a8c2f96e41f4cbe7.jpg_814x814Q100.jpg",
                        "https://salt.tikicdn.com/ts/product/8c/83/bd/4e581e89d5325f95230171c5cc72e454.jpg",
                        "https://media3.scdn.vn/img4/2020/10_18/MnESRQeq04hno5Q4Z1oQ_simg_b5529c_250x250_maxb.jpg",
                        "https://media3.scdn.vn/img3/2019/4_13/lmrmy5_simg_b5529c_250x250_maxb.jpg",
                        "https://media3.scdn.vn/img2/2018/7_30/sK6axV_simg_b5529c_250x250_maxb.jpg",
                        "https://media3.scdn.vn/img3/2019/10_14/t4tyjy_simg_b5529c_250x250_maxb.jpg",
                        "https://media3.scdn.vn/img3/2019/10_14/t4tyjy_simg_b5529c_250x250_maxb.jpg",
                        "https://media3.scdn.vn/img3/2019/3_7/CYu9xf_simg_b5529c_250x250_maxb.jpg",
                        "https://media3.scdn.vn/img3/2019/1_1/eC549t_simg_b5529c_250x250_maxb.jpg",
                        "https://media3.scdn.vn/img3/2019/7_23/29n4Mg_simg_b5529c_250x250_maxb.jpg",
                        "https://media3.scdn.vn/img2/2018/8_19/38HxoQ_simg_b5529c_250x250_maxb.jpg",
                        "https://media3.scdn.vn/img4/2020/06_22/Nk5ykGj71HfAyyGkUXPt_simg_b5529c_250x250_maxb.jpg",
                        "https://media3.scdn.vn/img3/2019/11_6/w3m1oi_simg_b5529c_250x250_maxb.jpg",
                        "https://gafa.vn/wp-content/uploads/2019/12/gi%C3%A0y-g%C3%B3t-trong-su%E1%BB%91t-8cm-3.jpg",
                        "https://gafa.vn/wp-content/uploads/2019/11/dsc_5082-768x768.jpg",
                        "https://gafa.vn/wp-content/uploads/2019/11/dsc_5082-768x768.jpg",
                        "https://gafa.vn/wp-content/uploads/2018/12/1-26-768x960.jpg",
                        "https://gafa.vn/wp-content/uploads/2018/12/Ziggy3.jpg",
                        "https://vn-test-11.slatic.net/p/30463f330b1b0e76a8c2f96e41f4cbe7.jpg_814x814Q100.jpg",
                        "https://salt.tikicdn.com/ts/product/8c/83/bd/4e581e89d5325f95230171c5cc72e454.jpg",
                        "https://media3.scdn.vn/img4/2020/10_18/MnESRQeq04hno5Q4Z1oQ_simg_b5529c_250x250_maxb.jpg",
                        "https://media3.scdn.vn/img3/2019/4_13/lmrmy5_simg_b5529c_250x250_maxb.jpg",
                        "https://media3.scdn.vn/img2/2018/7_30/sK6axV_simg_b5529c_250x250_maxb.jpg",
                        "https://media3.scdn.vn/img3/2019/10_14/t4tyjy_simg_b5529c_250x250_maxb.jpg",
                        "https://media3.scdn.vn/img3/2019/10_14/t4tyjy_simg_b5529c_250x250_maxb.jpg",
                        "https://media3.scdn.vn/img3/2019/3_7/CYu9xf_simg_b5529c_250x250_maxb.jpg",
                        "https://media3.scdn.vn/img3/2019/1_1/eC549t_simg_b5529c_250x250_maxb.jpg",
                        "https://media3.scdn.vn/img3/2019/7_23/29n4Mg_simg_b5529c_250x250_maxb.jpg",
                        "https://media3.scdn.vn/img2/2018/8_19/38HxoQ_simg_b5529c_250x250_maxb.jpg",
                        "https://media3.scdn.vn/img4/2020/06_22/Nk5ykGj71HfAyyGkUXPt_simg_b5529c_250x250_maxb.jpg",
                        "https://media3.scdn.vn/img3/2019/11_6/w3m1oi_simg_b5529c_250x250_maxb.jpg",
                };

    }
}
