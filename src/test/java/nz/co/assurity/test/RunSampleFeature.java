package nz.co.assurity.test;

import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * A sample runner class
 *
 * @author: Assurity
 * Date: 1/17/16
 * Time: 3:46 PM
 * To change this template use File | Settings | Editor |File and code Templates.
 */
@RunWith(Cucumber.class)
@cucumber.api.CucumberOptions(
//    Enable one of these to run just some tests. Put regexp to match features in here.
//    name = {"^Preview"},
//    name = {"^Save"},
//    tags = { "@questionLibrary", "@addingCategory" },
        format = {"html:target/cucumber-html-report", "pretty:target/cucumber-json-report.json"},
        strict = true,
        features = "classpath:nz\\co\\assurity\\test\\Sample.feature"
)
public class RunSampleFeature {

}
