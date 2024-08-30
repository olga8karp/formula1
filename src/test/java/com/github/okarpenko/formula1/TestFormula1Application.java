package com.github.okarpenko.formula1;

import org.springframework.boot.SpringApplication;

public class TestFormula1Application {

    public static void main(String[] args) {
        SpringApplication.from(Formula1Application::main).with(TestcontainersConfiguration.class).run(args);
    }

}
