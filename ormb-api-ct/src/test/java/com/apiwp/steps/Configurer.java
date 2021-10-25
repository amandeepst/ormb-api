package com.apiwp.steps;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.worldpay.servicing.model.entity.SRV130;
import com.worldpay.servicing.model.entity.SRV131;
import com.worldpay.servicing.model.entity.SRV133;
import com.worldpay.servicing.model.entity.SRV132;
import cucumber.api.TypeRegistry;
import cucumber.api.TypeRegistryConfigurer;
import io.cucumber.datatable.DataTableType;
import io.cucumber.datatable.TableEntryTransformer;
import java.util.Locale;
import java.util.Map;

public class Configurer implements TypeRegistryConfigurer {

  @Override
  public Locale locale() {
    return Locale.ENGLISH;
  }

  @Override
  public void configureTypeRegistry(TypeRegistry typeRegistry) {

    typeRegistry.defineDataTableType(new DataTableType(SRV131.class,
        new TableEntryTransformer<SRV131>() {
          @Override
          public SRV131 transform(Map<String, String> list) throws Throwable {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.convertValue(list, SRV131.class);
          }
        }));
    
    typeRegistry.defineDataTableType(new DataTableType(SRV130.class,
            new TableEntryTransformer<SRV130>() {
              @Override
              public SRV130 transform(Map<String, String> list) throws Throwable {
                ObjectMapper mapper = new ObjectMapper();
                return mapper.convertValue(list, SRV130.class);
              }
            }));
    
    typeRegistry.defineDataTableType(new DataTableType(SRV133.class,
            new TableEntryTransformer<SRV133>() {
              @Override
              public SRV133 transform(Map<String, String> list) throws Throwable {
                ObjectMapper mapper = new ObjectMapper();
                return mapper.convertValue(list, SRV133.class);
              }
            }));
    
    typeRegistry.defineDataTableType(new DataTableType(SRV132.class,
            new TableEntryTransformer<SRV132>() {
              @Override
              public SRV132 transform(Map<String, String> list) throws Throwable {
                ObjectMapper mapper = new ObjectMapper();
                return mapper.convertValue(list, SRV132.class);
              }
            }));
  
    
  }
}
