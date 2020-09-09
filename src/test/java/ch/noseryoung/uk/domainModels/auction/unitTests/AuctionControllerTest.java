package ch.noseryoung.uk.domainModels.auction.unitTests;

import org.assertj.core.api.Assertions;
import ch.noseryoung.uk.domainModels.auction.Auction;
import ch.noseryoung.uk.domainModels.auction.AuctionService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;

import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;
import java.util.List;


import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.hamcrest.Matchers.hasSize;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class AuctionControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private AuctionService auctionService;


    private Auction auctionToBeTestetAgainst;
    private Auction secondAuctionToBeTestetAgainst;
    private List<Auction> listAuctionToBeTestetAgainst;

    private double min;
    private double max;

    @BeforeEach
    void setUp() {
         auctionToBeTestetAgainst = new Auction().setId(1).setName("Testauction").setPrice(5);
         secondAuctionToBeTestetAgainst = new Auction().setId(1).setName("Testauction").setPrice(5);
         listAuctionToBeTestetAgainst = Arrays.asList(auctionToBeTestetAgainst, secondAuctionToBeTestetAgainst);
         min = 1;
         max = 1;
    }

    @Test
    public void NF123441_getById_requestAuctionById_returnsAuction() throws Exception{
        given(auctionService.findById(anyInt())).will(invocation -> {
           if ("non-existent".equals(invocation.getArgument(0))) throw new Exception();
           return auctionToBeTestetAgainst;
        });

        mvc.perform(
                MockMvcRequestBuilders.get("/auctions/{id}", auctionToBeTestetAgainst.getId())
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(auctionToBeTestetAgainst.getId()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value(auctionToBeTestetAgainst.getName()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.reason").value(auctionToBeTestetAgainst.getReason()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.price").value(auctionToBeTestetAgainst.getPrice()));

        ArgumentCaptor<Integer> integerArgumentCaptor = ArgumentCaptor.forClass(Integer.class);
        verify(auctionService, times(1)).findById(integerArgumentCaptor.capture());
        Assertions.assertThat(integerArgumentCaptor.getValue()).isEqualTo(auctionToBeTestetAgainst.getId());
    }

    @Test
    public void NF123442_getAll_requestAllAuctions_returnsAllAuctions() throws Exception{
        given(auctionService.findAll()).willReturn(listAuctionToBeTestetAgainst);


        mvc.perform(
                MockMvcRequestBuilders.get("/auctions")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(2)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id").value(listAuctionToBeTestetAgainst.get(0).getId()))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].id").value(listAuctionToBeTestetAgainst.get(1).getId()))

                .andExpect(MockMvcResultMatchers.jsonPath("$[0].name").value(listAuctionToBeTestetAgainst.get(0).getName()))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].name").value(listAuctionToBeTestetAgainst.get(1).getName()))

                .andExpect(MockMvcResultMatchers.jsonPath("$[0].reason").value(listAuctionToBeTestetAgainst.get(0).getReason()))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].reason").value(listAuctionToBeTestetAgainst.get(1).getReason()))

                .andExpect(MockMvcResultMatchers.jsonPath("$[0].price").value(listAuctionToBeTestetAgainst.get(0).getPrice()))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].price").value(listAuctionToBeTestetAgainst.get(1).getPrice()));

        verify(auctionService, times(1)).findAll();



    }

    @Test
    public void NF123443_getAllBetween_requestBetweenTwoLimits_expextCorrectAuctionsInBetween() throws Exception{
        given(auctionService.findAllBetween(anyDouble(), anyDouble())).will(invocation -> {
            if ("non-existent".equals(invocation.getArgument(0))) throw new Exception();
            return listAuctionToBeTestetAgainst;
        });


        mvc.perform(
                MockMvcRequestBuilders.get("/auctions/{number1}/{number2}", min, max)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(2)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id").value(listAuctionToBeTestetAgainst.get(0).getId()))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].id").value(listAuctionToBeTestetAgainst.get(1).getId()))

                .andExpect(MockMvcResultMatchers.jsonPath("$[0].name").value(listAuctionToBeTestetAgainst.get(0).getName()))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].name").value(listAuctionToBeTestetAgainst.get(1).getName()))

                .andExpect(MockMvcResultMatchers.jsonPath("$[0].reason").value(listAuctionToBeTestetAgainst.get(0).getReason()))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].reason").value(listAuctionToBeTestetAgainst.get(1).getReason()))

                .andExpect(MockMvcResultMatchers.jsonPath("$[0].price").value(listAuctionToBeTestetAgainst.get(0).getPrice()))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].price").value(listAuctionToBeTestetAgainst.get(1).getPrice()));


        ArgumentCaptor<Double> doubleArgumentCaptor = ArgumentCaptor.forClass(Double.class);
        ArgumentCaptor<Double> secondDoubleArgumentCaptor = ArgumentCaptor.forClass(Double.class);
        verify(auctionService, times(1)).findAllBetween(doubleArgumentCaptor.capture(),secondDoubleArgumentCaptor.capture());
        Assertions.assertThat(doubleArgumentCaptor.getValue()).isEqualTo(min);
        Assertions.assertThat(secondDoubleArgumentCaptor.getValue()).isEqualTo(max);
    }

    @AfterEach
    void tearDown() {
    }
}