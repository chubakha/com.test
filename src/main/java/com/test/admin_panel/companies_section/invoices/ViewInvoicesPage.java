package com.test.admin_panel.companies_section.invoices;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class ViewInvoicesPage {

    private final SelenideElement companyNameText = $x("//th[text() = 'Company Name']/following-sibling::td/a");
    private final SelenideElement serviceText = $x("//th[text() = 'Service']/following-sibling::td");
    private final SelenideElement statusText = $x("//th[text() = 'Status']/following-sibling::td");
    private final SelenideElement sumText = $x("//th[text() = 'Sum']/following-sibling::td");
    private final SelenideElement timestampText = $x("//th[text() = 'Timestamp']/following-sibling::td");

    public String getCompanyNameText(){
        return companyNameText.text();
    }

    public String getServiceText(){
        return serviceText.text();
    }

    public String getStatusText(){
        return statusText.text();
    }

    public int getSumText(){
        return Integer.parseInt(sumText.text().substring(0, sumText.text().indexOf(".")));
    }

    public String getTimestampText(){
        return timestampText.text();
    }
}
