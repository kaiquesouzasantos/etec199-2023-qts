import component.PageActions;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;

@Slf4j
public class AnaliseValorLimiteTest {
    private PageActions pageActions;
    private final String NOME = "TESTE", CPF = "51248547829";

    @BeforeEach
    private void setUp() {
        pageActions = new PageActions();
    }

    @Test
    public void ts01() {
        Assertions.assertEquals(
                "0%",
                pageActions.retornaAliquota(NOME, "22847.75", CPF)
        );
    }

    @Test
    public void ts02() {
        Assertions.assertEquals(
                "0%",
                pageActions.retornaAliquota(NOME, "22847.76", CPF)
        );
    }

    @Test
    public void ts03() {
        Assertions.assertEquals(
                "7.5%",
                pageActions.retornaAliquota(NOME, "22847.77", CPF)
        );
    }

    @Test
    public void ts04() {
        Assertions.assertEquals(
                "7.5%",
                pageActions.retornaAliquota(NOME, "33919.79", CPF)
        );
    }

    @Test
    public void ts05() {
        Assertions.assertEquals(
                "7.5%",
                pageActions.retornaAliquota(NOME, "33919.80", CPF)
        );
    }

    @Test
    public void ts06() {
        Assertions.assertEquals(
                "15%",
                pageActions.retornaAliquota(NOME, "33919.81", CPF)
        );
    }

    @Test
    public void ts07() {
        Assertions.assertEquals(
                "15%",
                pageActions.retornaAliquota(NOME, "45012.59", CPF)
        );
    }

    @Test
    public void ts08() {
        Assertions.assertEquals(
                "15%",
                pageActions.retornaAliquota(NOME, "45012.60", CPF)
        );
    }

    @Test
    public void ts09() {
        Assertions.assertEquals(
                "22.5%",
                pageActions.retornaAliquota(NOME, "45012.61", CPF)
        );
    }

    @Test
    public void ts10() {
        Assertions.assertEquals(
                "22.5%",
                pageActions.retornaAliquota(NOME, "55976.15", CPF)
        );
    }

    @Test
    public void ts11() {
        Assertions.assertEquals(
                "22.5%",
                pageActions.retornaAliquota(NOME, "55976.16", CPF)
        );
    }

    @Test
    public void ts12() {
        Assertions.assertEquals(
                "27.5%",
                pageActions.retornaAliquota(NOME, "55976.17", CPF)
        );
    }

    @Test
    public void ts13() {
        Assertions.assertEquals(
                "27.5%",
                pageActions.retornaAliquota(NOME, "55976.17", CPF)
        );
    }

    @Test
    public void ts14() {
        Assertions.assertEquals(
                "27.5%",
                pageActions.retornaAliquota(NOME, "55976.18", CPF)
        );
    }

    @Test
    public void ts15() {
        Assertions.assertEquals(
                "27.5%",
                pageActions.retornaAliquota(NOME, "55976.19", CPF)
        );
    }

    @AfterEach
    private void tearUp(){
        pageActions.fechaJanela();
    }
}