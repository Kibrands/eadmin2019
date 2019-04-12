package es.fpdual.primero.eadmin.mapper;

import org.junit.runner.*;
import org.springframework.test.context.*;
import org.springframework.test.context.junit4.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:spring-configuration/eadmin-sqlserver-persistencia.xml",
		"classpath:spring-configuration/eadmin-persistencia.xml" })
public class SQLServerDocumentoMapperTest extends BaseDocumentoMapperTest {

}
