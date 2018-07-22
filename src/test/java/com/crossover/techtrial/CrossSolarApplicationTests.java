package com.crossover.techtrial;

import com.crossover.techtrial.model.HourlyElectricity;
import com.crossover.techtrial.model.Panel;
import com.crossover.techtrial.service.HourlyElectricityServiceImpl;
import com.crossover.techtrial.service.PanelServiceImpl;

import java.time.LocalDateTime;

import org.apache.logging.log4j.CloseableThreadContext.Instance;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CrossSolarApplicationTests {
/*
  @InjectMocks
  PanelServiceImpl service;

  @InjectMocks
  HourlyElectricityServiceImpl hourlyElectricityService;
  String serial="1234567890123456";
  @Before
  public void setup() throws Exception {
    mockMvc = MockMvcBuilders.standaloneSetup(service,hourlyElectricityService).build();
  }*/

  @Test
  public void contextLoads() {
    
  }

 /* @Test
  @Before
  public void insertPanel(){
    
    Panel panel =new Panel();
    panel.setBrand("Test");
    panel.setLatitude(123456.0);
    panel.setLongitude(123456.0);
    panel.setSerial("1234567890123456");
    service.register(panel);
    Panel object = service.findBySerial(serial);
    Assert.assertNotNull(object);
    Assert.assertSame(object,panel);
    Assert.assertTrue(panel.getBrand().equalsIgnoreCase(object.getBrand()));
  }
  
  @Test
  public void insertHourlyElectricity() {
	  HourlyElectricity hourlyElectricity=new HourlyElectricity();
	  Panel object = service.findBySerial(serial);
	  hourlyElectricity.setPanel(object);
	  
	  hourlyElectricity.setReadingAt(LocalDateTime.now());
	  hourlyElectricity.setGeneratedElectricity(Long.valueOf("321"));
	  hourlyElectricityService.save(hourlyElectricity);
	  
	  Page<HourlyElectricity> retrivedObject = hourlyElectricityService.getAllHourlyElectricityByPanelId(object.getId(),null);
	  
	  Assert.assertNotNull(retrivedObject);
	    Assert.assertSame(retrivedObject,hourlyElectricity);
	  
  }
*/
}
