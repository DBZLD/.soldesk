import React from 'react';
import Table from '@mui/material/Table';
import TableBody from '@mui/material/TableBody';
import TableCell from '@mui/material/TableCell';
import TableContainer from '@mui/material/TableContainer';
import TableHead from '@mui/material/TableHead';
import TableRow from '@mui/material/TableRow';
import Paper from '@mui/material/Paper';


// 나todo: 정렬, 페이징, 체크박스, 검색 필터 내용도 추가하기
export default function CatTable() {
  // 고양이 정보 샘플 데이터
  const rows = [
    { name: '나비', age: 2, grade: 'SSR' },
    { name: '치즈', age: 1, grade: 'SR' },
    { name: '까망이', age: 3, grade: 'R' },
  ];

  return (
    // Paper로 감싸서 배경 카드 느낌
    <TableContainer component={Paper}>
      {/* Table: 전체 테이블 */}
      <Table>
        {/* TableHead: 헤더 영역 */}
        <TableHead>
          <TableRow>
            <TableCell>이름</TableCell>
            <TableCell align="right">나이</TableCell>
            <TableCell align="right">등급</TableCell>
          </TableRow>
        </TableHead>

        {/* TableBody: 실제 데이터 출력 */}
        <TableBody>
          {rows.map((row, idx) => (
            <TableRow key={idx}>
              <TableCell>{row.name}</TableCell>
              <TableCell align="right">{row.age}</TableCell>
              <TableCell align="right">{row.grade}</TableCell>
            </TableRow>
          ))}
        </TableBody>
      </Table>
    </TableContainer>
  );
}
