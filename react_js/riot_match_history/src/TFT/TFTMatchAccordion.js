import React, { useState } from "react";
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

function AccordionExpandFullRow() {
  const [open, setOpen] = useState(false);

  return (
    <TableContainer component={Paper}>
      <Table>
        <TableBody>
          <TableRow>
            {/* 1열 */}
            <TableCell>등수</TableCell>
            <TableCell colSpan={3}>게임 형식 | 게임 시간 | 게임 일자</TableCell>
            {/* 2열 병합 + 토글 버튼 */}
            <TableCell rowSpan={2}  sx={{
               verticalAlign: "bottom", 
               backgroundColor: "grey"
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
          <TableRow>
            <TableCell style={{width:'7%'}}>전설이</TableCell>
            <TableCell style={{width:'15%'}}>특성</TableCell>
            <TableCell style={{width:'60%'}}>챔피언</TableCell>
            <TableCell style={{width:'18%'}}>매칭</TableCell>
          </TableRow>

          {/* 확장되는 전체 너비 행 */}
          {open && (
            <TableRow>
              {/* colSpan 5으로 전체 열 합침 */}
              <TableCell colSpan={5} style={{ paddingBottom: 0, paddingTop: 0 }}>
                <Collapse in={open} timeout="auto" unmountOnExit>
                  <Box margin={2}>
                    <Typography variant="h6" gutterBottom>
                        확장 테이블
                    </Typography>
                    {/* 이 안에 원하는 내용을 넣으면 됩니다 */}
                    <Table size="small" aria-label="expanded table">
                      <TableHead>
                        <TableRow sx={{"& th, &td": {textAlign:"center"},}}>
                          <TableCell style={{width:'5%'}}>등수</TableCell>
                          <TableCell style={{width:'10%'}}>플레이어</TableCell>
                          <TableCell style={{width:'7%'}}>라운드</TableCell>
                          <TableCell style={{width:'15%'}}>특성</TableCell>
                          <TableCell style={{width:'56%'}}>챔피언</TableCell>
                          <TableCell style={{width:'7%'}}>업적</TableCell>
                        </TableRow>
                      </TableHead>
                      <TableBody>
                        <TableRow>
                          <TableCell>1</TableCell>
                          <TableCell>1</TableCell>
                          <TableCell>1</TableCell>
                          <TableCell>1</TableCell>
                          <TableCell>1</TableCell>
                          <TableCell>1</TableCell>
                        </TableRow>
                        <TableRow>
                          <TableCell>2</TableCell>
                          <TableCell>2</TableCell>
                          <TableCell>2</TableCell>
                          <TableCell>2</TableCell>
                          <TableCell>2</TableCell>
                          <TableCell>2</TableCell>
                        </TableRow>
                        <TableRow>
                          <TableCell>3</TableCell>
                          <TableCell>3</TableCell>
                          <TableCell>3</TableCell>
                          <TableCell>3</TableCell>
                          <TableCell>3</TableCell>
                          <TableCell>3</TableCell>
                        </TableRow>
                        <TableRow>
                          <TableCell>4</TableCell>
                          <TableCell>4</TableCell>
                          <TableCell>4</TableCell>
                          <TableCell>4</TableCell>
                          <TableCell>4</TableCell>
                          <TableCell>4</TableCell>
                        </TableRow>
                        <TableRow>
                          <TableCell>5</TableCell>
                          <TableCell>5</TableCell>
                          <TableCell>5</TableCell>
                          <TableCell>5</TableCell>
                          <TableCell>5</TableCell>
                          <TableCell>5</TableCell>
                        </TableRow>
                        <TableRow>
                          <TableCell>6</TableCell>
                          <TableCell>6</TableCell>
                          <TableCell>6</TableCell>
                          <TableCell>6</TableCell>
                          <TableCell>6</TableCell>
                          <TableCell>6</TableCell>
                        </TableRow>
                        <TableRow>
                          <TableCell>7</TableCell>
                          <TableCell>7</TableCell>
                          <TableCell>7</TableCell>
                          <TableCell>7</TableCell>
                          <TableCell>7</TableCell>
                          <TableCell>7</TableCell>
                        </TableRow>
                        <TableRow>
                          <TableCell>8</TableCell>
                          <TableCell>8</TableCell>
                          <TableCell>8</TableCell>
                          <TableCell>8</TableCell>
                          <TableCell>8</TableCell>
                          <TableCell>8</TableCell>
                        </TableRow>
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
