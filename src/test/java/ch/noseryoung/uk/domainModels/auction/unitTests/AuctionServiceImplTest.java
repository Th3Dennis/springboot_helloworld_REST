package ch.noseryoung.uk.domainModels.auction.unitTests;

import ch.noseryoung.uk.domainModels.auction.AuctionRepository;
import ch.noseryoung.uk.domainModels.auction.Auction;
import ch.noseryoung.uk.domainModels.auction.AuctionService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;


@RunWith(SpringRunner.class)
@SpringBootTest
class AuctionServiceImplTest {

    @Autowired
    private AuctionService auctionService;

    @MockBean
    private AuctionRepository auctionRepository;

    private Auction auctionToBeTestetAgainst;
    private Auction secondAuctionToBeTestetAgainst;
    private Auction thirdAuctionToBeTestetAgainst;
    private List<Auction> listAuctionToBeTestetAgainst;


    @BeforeEach
    void setUp() {
        auctionToBeTestetAgainst = new Auction().setId(1).setName("Testauction").setPrice(5);
        secondAuctionToBeTestetAgainst = new Auction().setId(2).setName("Testauction2").setPrice(10);
        thirdAuctionToBeTestetAgainst = new Auction().setId(3).setName("Testauction3").setPrice(-1);
        listAuctionToBeTestetAgainst = Arrays.asList(auctionToBeTestetAgainst, secondAuctionToBeTestetAgainst, thirdAuctionToBeTestetAgainst);
    }

    @Test
    public void NF123443_getAllBetween_requestBetweenTwoLimits_expectCorrectAuctionsInBetween() throws Exception {
        given(auctionRepository.findAll()).willReturn(listAuctionToBeTestetAgainst);

        List<Auction> auctionList = auctionService.findAllBetween(5, 9);

        Assertions.assertThat(auctionList.size()).isEqualTo(1);
        Assertions.assertThat(auctionList.get(0).getId()).isEqualTo(auctionToBeTestetAgainst.getId());
        Assertions.assertThat(auctionList.get(0).getPrice()).isEqualTo(auctionToBeTestetAgainst.getPrice());


        verify(auctionRepository, times(1)).findAll();
    }


    @AfterEach
    void tearDown() {
    }
}