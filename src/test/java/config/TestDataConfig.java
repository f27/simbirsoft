package config;

import org.aeonbits.owner.Config;

import static org.aeonbits.owner.Config.LoadType.MERGE;

@Config.LoadPolicy(MERGE)
@Config.Sources({
        "system:properties",
        "classpath:config/testdata.properties"
})
public interface TestDataConfig extends Config {
    @Key("web.url")
    String webUrl();

    @Key("site.main.header")
    String[] siteMainHeader();

    @Key("site.main.phone")
    String[] siteMainPhone();

    @Key("site.main.footer.fb")
    String[] siteMainFooterFb();

    @Key("site.agreement")
    String[] siteAgreement();

    @Key("site.portfolio.technologies.java")
    String[] sitePortfolioTechnologiesJava();

    @Key("site.help.save")
    String[] siteHelpSave();

    @Key("elements.button.contact")
    String[] elementsButtonContact();

    @Key("elements.link.agreement")
    String[] elementsLinkAgreement();
}
