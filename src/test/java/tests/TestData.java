package tests;

import config.TestDataConfig;
import org.aeonbits.owner.ConfigFactory;

import java.util.*;

public class TestData {
    private static final TestDataConfig testDataConfig = ConfigFactory.create(TestDataConfig.class, System.getProperties());

    public static String getWebUrl() {
        return testDataConfig.webUrl();
    }

    public static String[] getLocales() {
        return testDataConfig.siteLocales();
    }

    public static Map<String, String> getMainHeader() {
        String[] dataArray = testDataConfig.siteMainHeader();
        return new HashMap<String, String>() {{
            put("ru", dataArray[0]);
            put("en", dataArray[1]);
        }};
    }

    public static Map<String, String> getMainPhone() {
        String[] dataArray = testDataConfig.siteMainPhone();
        return new HashMap<String, String>() {{
            put("ru", dataArray[0]);
            put("en", dataArray[1]);
        }};
    }

    public static Map<String, String> getMainFooterFb() {
        String[] dataArray = testDataConfig.siteMainFooterFb();
        return new HashMap<String, String>() {{
            put("ru", dataArray[0]);
            put("en", dataArray[1]);
        }};
    }

    public static Map<String, String> getAgreement() {
        String[] dataArray = testDataConfig.siteAgreement();
        return new HashMap<String, String>() {{
            put("ru", dataArray[0]);
            put("en", dataArray[1]);
        }};
    }

    public static Map<String, String> getPortfolioTechnologiesJava() {
        String[] dataArray = testDataConfig.sitePortfolioTechnologiesJava();
        return new HashMap<String, String>() {{
            put("ru", dataArray[0]);
            put("en", dataArray[1]);
        }};
    }

    public static Map<String, String> getHelpSave() {
        String[] dataArray = testDataConfig.siteHelpSave();
        return new HashMap<String, String>() {{
            put("ru", dataArray[0]);
            put("en", dataArray[1]);
        }};
    }

    public static Map<String, String> getElementsButtonContact() {
        String[] dataArray = testDataConfig.elementsButtonContact();
        return new HashMap<String, String>() {{
            put("ru", dataArray[0]);
            put("en", dataArray[1]);
        }};
    }

    public static Map<String, String> getElementsLinkAgreement() {
        String[] dataArray = testDataConfig.elementsLinkAgreement();
        return new HashMap<String, String>() {{
            put("ru", dataArray[0]);
            put("en", dataArray[1]);
        }};
    }
}
