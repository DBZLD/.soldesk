import React, { useState } from "react";
import { useNavigate } from 'react-router-dom';
import {
  Table,
  TableBody,
  TableCell,
  TableContainer,
  TableHead,
  TableRow,
  Paper,
  Collapse,
  IconButton,
  Box,
  Typography,
} from "@mui/material";
import { KeyboardArrowDown, KeyboardArrowUp } from "@mui/icons-material";
import './TFTAccordian.css';

function AccordionExpandFullRow({data}) {
  const [open, setOpen] = useState(false);
  const navigate = useNavigate();

  function printUnitTier(count, unitRarity){
    return <h4 className={`unitRarity${unitRarity}`}>{"★".repeat(count)}</h4>;
  }
    function printExUnitTier(count, unitRarity){
    return <h5 className={`unitRarity${unitRarity}`}>{"★".repeat(count)}</h5>;
  }
  return (
    <TableContainer component={Paper} sx={{marginBottom:'20px', backgroundColor:'rgb(70, 70, 70)'}}>
      <Table>
        <TableBody>
          <TableRow sx={{height:'50px'}}>
            {/* 1열 */}
            <TableCell sx={{color: 'rgb(170, 170, 170)', fontWeight:'900'}}>{data.playerInfos[data.myIndex].placement}등</TableCell>
            <TableCell sx={{color: 'rgb(170, 170, 170)'}} colSpan={3}>{data.queueType} | {data.playerInfos[data.myIndex].timeElemented} | {data.gameDatetime}</TableCell>
            {/* 2열 */}
            <TableCell rowSpan={2}  sx={{
               verticalAlign: "bottom", 
               backgroundColor: "gray",
               width:"15px"
              }}>
              <IconButton
                aria-label="expand"
                size="small"
                onClick={() => setOpen(!open)}
                sx={{color:"white !important"}}
              >
                {open ? <KeyboardArrowUp /> : <KeyboardArrowDown />}
              </IconButton>
            </TableCell>
          </TableRow>
          <TableRow sx={{height:'90px'}}>
            <TableCell className="cellWidth">
              <div className="playerCell">
              <img className="playerTactician" src={data.playerInfos[data.myIndex].tacticianImgURL} alt="tactician"></img>
              <h4 className="playerLevel">{data.playerInfos[data.myIndex].level}</h4>
              </div>
            </TableCell>
            <TableCell className="traitWidth">
              <div className="traitCell">
              {data.playerInfos[data.myIndex].traitList.slice(0, data.playerInfos[data.myIndex].traitList.length).map((trait, index) => (
                <img key={index} className={`traitImg traitTier${trait.style}`}src={trait.imgURL} alt="traitImg"></img>
              ))}
              </div>
            </TableCell>
            <TableCell className="unitWidth">
              <div className="unitCell">
              {data.playerInfos[data.myIndex].unitList.slice(0, data.playerInfos[data.myIndex].unitList.length).map((unit, index) => (
                <div className="unitBox">
                  {printUnitTier(unit.tier, unit.rarity)}
                  <img key={index} className={`unitImg unitRarity${unit.rarity}`}src={unit.imgURL} alt="unitImg"></img> 
                   <div>
                     <div className="itemBox">
                  {unit.itemList.slice(0, unit.itemList.length).map((item, index) => (
                      <img key={index} className="itemImg" src={item.imgURL} alt="itemImg"></img>
                    ))}
                    </div>
                  </div>
                </div>
              ))}
              </div>
            </TableCell>
            <TableCell className="matchmateWidth">
              <div className="matchmateCell">
                {data.playerInfos.slice(0, data.playerInfos.length).map((player, index) => (
                  <div key={index} className="matchmate">
                    <img className="matchmateIcon" src={player.tacticianImgURL} alt="tacticianImg"></img>
                      <div
                        className="matchmateName"
                        onClick={() => navigate(`/TFTRecord?id=${player.playerId}&tag=${player.playerTag}`)}>
                        {player.playerId.length <= 8 ? player.playerId : player.playerId.slice(0, 8) + "..."}
                      </div>
                  </div>
                ))}
              </div>
            </TableCell>
          </TableRow>

          {open && (
            <TableRow>
              <TableCell colSpan={5} style={{ paddingBottom: 0, paddingTop: 0, color:"rgb(170, 170, 170)"}}>
                <Collapse in={open} timeout="auto" unmountOnExit>
                  <Box margin={2}>
                    <Typography variant="h7" gutterBottom>
                        확장 테이블
                    </Typography>
                    <Table size="small" aria-label="expanded table">
                      <TableHead>
                        <TableRow sx={{"& th, &td": {color:"rgb(170, 170, 170)"},}}>
                          <TableCell sx={{width:'6%', textAlign:"center"}}>등수</TableCell>
                          <TableCell sx={{width:'14%'}}>플레이어</TableCell>
                          <TableCell sx={{width:'7%', textAlign:"center"}}>라운드</TableCell>
                          <TableCell sx={{width:'15%', textAlign:"center"}}>특성</TableCell>
                          <TableCell sx={{width:'40%', textAlign:"center"}}>챔피언</TableCell>
                          <TableCell sx={{width:'6%'}}>업적</TableCell>
                        </TableRow>
                      </TableHead>
                      <TableBody>
                          {data.playerInfos.slice(0, data.playerInfos.length).map((player, index) => (
                            <TableRow>
                              <TableCell sx={{color:"rgb(170, 170, 170)", textAlign:"center"}}>{player.placement}</TableCell>
                              <TableCell sx={{color:"rgb(170, 170, 170)"}}>{player.playerId}</TableCell>
                              <TableCell sx={{color:"rgb(170, 170, 170)", textAlign:"center"}}>{player.lastRound}<br />{player.timeElemented}</TableCell>
                              <TableCell sx={{color:"rgb(170, 170, 170)"}}>
                                <div className="exTraitCell">
                                {player.traitList.slice(0, player.traitList.length).map((trait, index) => (
                                  <img key={index} className={`exTraitImg traitTier${trait.style}`}src={trait.imgURL} alt="exTraitImg"></img>
                                ))}
                                </div>
                              </TableCell>
                              <TableCell sx={{color:"rgb(170, 170, 170)"}}>
                                <div className="exUnitCell">
                                  {player.unitList.slice(0, player.unitList.length).map((unit, index) => (
                                    <div className="exUnitBox">
                                      {printExUnitTier(unit.tier, unit.rarity)}
                                      <img key={index} className={`exUnitImg unitRarity${unit.rarity}`}src={unit.imgURL} alt="exUnitImg"></img> 
                                      <div>
                                        <div className="exItemBox">
                                      {unit.itemList.slice(0, unit.itemList.length).map((item, index) => (
                                          <img key={index} className="exItemImg" src={item.imgURL} alt="exItemImg"></img>
                                        ))}
                                        </div>
                                      </div>
                                    </div>
                                  ))}
                                </div>
                              </TableCell>
                              <TableCell sx={{color:"rgb(170, 170, 170)"}}>{player.totalDamage}<br/>{player.goldLeft}</TableCell>
                            </TableRow>
                          ))}
                      </TableBody>
                    </Table>
                  </Box>
                </Collapse>
              </TableCell>
            </TableRow>
          )}
        </TableBody>
      </Table>
    </TableContainer>
  );
}

export default AccordionExpandFullRow;
