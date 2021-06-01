package cl.acl.desafio1.service.impl;

import cl.acl.desafio1.model.PeriodModel;
import cl.acl.desafio1.service.PeriodService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public interface ImplPeriodService  {

        public PeriodModel findDates(PeriodModel input);

}