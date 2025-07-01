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
            <TableCell colSpan={4}>등수 | 게임 형식 | 게임 시간 | 게임 일자</TableCell>
            {/* 2열 병합 + 토글 버튼 */}
            <TableCell rowSpan={2} style={{ verticalAlign: "bottom" }}>
              <IconButton
                aria-label="expand"
                size="small"
                onClick={() => setOpen(!open)}
              >
                {open ? <KeyboardArrowUp /> : <KeyboardArrowDown />}
              </IconButton>
            </TableCell>
          </TableRow>
          <TableRow>
            <TableCell style={{width:'7%'}}>전설이</TableCell>
            <TableCell style={{width:'15%'}}>특성</TableCell>
            <TableCell style={{width:'55%'}}>챔피언</TableCell>
            <TableCell style={{width:'23%'}}>매칭</TableCell>
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
                        <TableRow>
                          <TableCell>등수</TableCell>
                          <TableCell>플레이어</TableCell>
                          <TableCell>라운드</TableCell>
                          <TableCell>특성</TableCell>
                          <TableCell>챔피언</TableCell>
                          <TableCell>입힌피해/남은골드</TableCell>
                        </TableRow>
                      </TableHead>
                      <TableBody>
                        <TableRow>
                          <TableCell>플레이어1</TableCell>
                          <TableCell>플레이어1</TableCell>
                          <TableCell>플레이어1</TableCell>
                          <TableCell>플레이어1</TableCell>
                          <TableCell>플레이어1</TableCell>
                          <TableCell>플레이어1</TableCell>
                        </TableRow>
                        <TableRow>
                          <TableCell>플레이어2</TableCell>
                          <TableCell>플레이어2</TableCell>
                          <TableCell>플레이어2</TableCell>
                          <TableCell>플레이어2</TableCell>
                          <TableCell>플레이어2</TableCell>
                          <TableCell>플레이어2</TableCell>
                        </TableRow>
                        <TableRow>
                          <TableCell>플레이어3</TableCell>
                          <TableCell>플레이어3</TableCell>
                          <TableCell>플레이어3</TableCell>
                          <TableCell>플레이어3</TableCell>
                          <TableCell>플레이어3</TableCell>
                          <TableCell>플레이어3</TableCell>
                        </TableRow>
                        <TableRow>
                          <TableCell>플레이어4</TableCell>
                          <TableCell>플레이어4</TableCell>
                          <TableCell>플레이어4</TableCell>
                          <TableCell>플레이어4</TableCell>
                          <TableCell>플레이어4</TableCell>
                          <TableCell>플레이어4</TableCell>
                        </TableRow>
                        <TableRow>
                          <TableCell>플레이어5</TableCell>
                          <TableCell>플레이어5</TableCell>
                          <TableCell>플레이어5</TableCell>
                          <TableCell>플레이어5</TableCell>
                          <TableCell>플레이어5</TableCell>
                          <TableCell>플레이어5</TableCell>
                        </TableRow>
                        <TableRow>
                          <TableCell>플레이어6</TableCell>
                          <TableCell>플레이어6</TableCell>
                          <TableCell>플레이어6</TableCell>
                          <TableCell>플레이어6</TableCell>
                          <TableCell>플레이어6</TableCell>
                          <TableCell>플레이어6</TableCell>
                        </TableRow>
                        <TableRow>
                          <TableCell>플레이어7</TableCell>
                          <TableCell>플레이어7</TableCell>
                          <TableCell>플레이어7</TableCell>
                          <TableCell>플레이어7</TableCell>
                          <TableCell>플레이어7</TableCell>
                          <TableCell>플레이어7</TableCell>
                        </TableRow>
                        <TableRow>
                          <TableCell>플레이어8</TableCell>
                          <TableCell>플레이어8</TableCell>
                          <TableCell>플레이어8</TableCell>
                          <TableCell>플레이어8</TableCell>
                          <TableCell>플레이어8</TableCell>
                          <TableCell>플레이어8</TableCell>
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
