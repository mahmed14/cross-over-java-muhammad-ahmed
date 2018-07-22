package com.crossover.techtrial.service;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import javax.validation.ConstraintViolationException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import com.crossover.techtrial.config.ServiceConfig;
import com.crossover.techtrial.model.Panel;
import com.crossover.techtrial.repository.PanelRepository;


@RunWith(SpringRunner.class)
@DataJpaTest
@Import(ServiceConfig.class)
public class PanelServiceTest {

    @Autowired
    private PanelService panelService;

    @Autowired
    private PanelRepository panelRepository;

    @Before
    @Sql("/delete_readings.sql")
    public void setup() {}

    @Test
    public void shouldRegisterPanel() throws Exception {
        panelService.register(Panel.of("232323", 54.123232, 54.123232, "Tesla"));
        Panel newPanel = panelRepository.findBySerial("232323");

        assertThat(newPanel).isNotNull();
        assertThat(newPanel.getId()).isNotNull();
        assertThat(newPanel.getBrand()).isEqualTo("Tesla");
    }

    @Test
    public void shouldFindPanel() throws Exception {
        panelRepository.save(Panel.of("232323", 54.123232, 54.123232, "Tesla"));
        Panel newPanel = panelService.findBySerial("232323");

        assertThat(newPanel).isNotNull();
        assertThat(newPanel.getBrand()).isEqualTo("Tesla");
    }

    @Test
    public void shouldIssueErroRegisterPanel_WithNullSerial() throws Exception {
        assertThatThrownBy(() ->
                panelService.register(Panel.of(null, 54.123232, 54.123232, "Tesla")))
                .isInstanceOf(ConstraintViolationException.class);
    }

    @Test
    public void shouldIssueErroRegisterPanel_WithNullLongitude() throws Exception {
        assertThatThrownBy(() ->
                panelService.register(Panel.of("232323", null, 54.123232, "Tesla")))
                .isInstanceOf(ConstraintViolationException.class);
    }

}