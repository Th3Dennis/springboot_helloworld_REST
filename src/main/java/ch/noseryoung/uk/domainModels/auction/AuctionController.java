package ch.noseryoung.uk.domainModels.auction;


import ch.noseryoung.uk.domainModels.auction.dto.AuctionDTO;
import ch.noseryoung.uk.domainModels.auction.dto.AuctionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auctions")
public class AuctionController {


    // The newly created services to be injected
    private AuctionService auctionService;

    private AuctionMapper auctionMapper;

    // Injecting the dependency via constructor
    @Autowired
    public AuctionController(AuctionService auctionService, AuctionMapper auctionMapper) {
        this.auctionService = auctionService;
        this.auctionMapper = auctionMapper;
    }

    // This endpoint creates a new auction with the data given
    @PostMapping({"/", ""})
    public ResponseEntity<AuctionDTO> create(@RequestBody AuctionDTO auctionDTO) {
        return new ResponseEntity<>(auctionMapper.toDTO(auctionService.create(auctionMapper.fromDTO(auctionDTO))), HttpStatus.CREATED);
    }



    // This endpoint retrieves all auctions as a list
    @GetMapping({"/", ""})
    public ResponseEntity<List<AuctionDTO>> getAll() {

        return new ResponseEntity<>(auctionMapper.toDTOs(auctionService.findAll()), HttpStatus.OK);
    }

    @GetMapping("/{number1}/{number2}")
    public ResponseEntity<List<AuctionDTO>> getAllBetween(@PathVariable double number1, @PathVariable double number2){
    return new ResponseEntity<>(auctionMapper.toDTOs(auctionService.findAllBetween(number1,number2)) , HttpStatus.OK);
    }

    // This endpoint retrieves a single auction by it's id
    @GetMapping("/{id}")
    public ResponseEntity<AuctionDTO> getById(@PathVariable int id) {
        return new ResponseEntity<>(auctionMapper.toDTO(auctionService.findById(id)), HttpStatus.OK);
    }

    // This endpoint updates an existing auction with the id and data given
    @PutMapping("/{id}")
    public ResponseEntity<AuctionDTO> updateById(@PathVariable int id, @RequestBody AuctionDTO auctionDTO) {
        return new ResponseEntity<>(auctionMapper.toDTO(auctionService.updateById(id, auctionMapper.fromDTO(auctionDTO))), HttpStatus.OK);
    }

    // This endpoint deletes an existing auction with the id given
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable int id) {
        auctionService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}


