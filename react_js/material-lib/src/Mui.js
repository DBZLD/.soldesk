import CatAppBar from "./CatAppBar";
import CatAppBarPlus from "./CatAppBarPlus";
import CatCard from "./CatCard";
import CatTab from "./CatTab";
import CatGrid from "./CatGrid";
import CatModal from "./CatModal";
import CatFab from "./CatFab";
import CatBottomNav from "./CatBottomNav";
import CatSnackBar from "./CatSnackBar";
import CatDialog from "./CatDialog";
import CatTable from "./CatTable";
import CatStepper from "./CatStepper";
import CatAccordion from "./CatAccordion";
import CatAvatar from "./CatAvatar";
import CatBreadcrumbs from "./CatBreadcrumbs";
import CatChip from "./CatChip";
import CatSkeleton from "./CatSkeleton";
import CatTooltip from "./CatTooltip";
import CatProgressBar from "./CatProgressBar";
import CatAlert from "./CatAlert";
import CatPopover from "./CatPopover";
import CatAvatarGroup from "./CatAvatarGroup";
import CatForm from "./CatForm";
import CatProgressAdvanced from "./CatProgressAdvanced";
import CatSkeletonList from "./CatSkeletonList";

export default function Mui() {
  return (
    <div>
      <h2>상단 네비게이션 바</h2>
      <CatAppBar />
      <CatAppBarPlus />
      <h2>카드 UI</h2>
      <div style={{ display: 'flex', flexWrap: 'wrap' }}>
        <CatCard />
        <CatCard />
      </div>
      <h2>탭</h2>
      <CatTab />
      <h2>그리드</h2>
      <CatGrid />
      <h2>모달</h2>
      <CatModal />
      <h2>플로팅 액션 버튼(FAB)</h2>
      <CatFab />
      <h2>하단 네비게이션 바 (탭 전환)</h2>
      <CatBottomNav />
      <h2>스낵바 </h2>
      <CatSnackBar />
      <h2>다이얼로그 </h2>
      <CatDialog />
      <h2>테이블 </h2>
      <CatTable />
      <h2>단계별 진행 표시기(스텝바)</h2>
      <CatStepper />
      <h2>아코디언 </h2>
      <CatAccordion />
      <h2>아바타 </h2>
      <CatAvatar />
      <h2>경로 표시(네비게이션 히어라키 표시) </h2>
      <CatBreadcrumbs />
      <h2>칩</h2>
      <CatChip />
      <h2>스켈레톤</h2>
      <CatSkeleton />
      <h2>툴팁</h2>
      <CatTooltip />
      <h2>프로그레스바</h2>
      <CatProgressBar />
      <h2>알러트</h2>
      <CatAlert />
      <h2>팝오버</h2>
      <CatPopover />
      <h2>아바타그룹</h2>
      <CatAvatarGroup />
      <h2>폼</h2>
      <CatForm />
      <h2>고급 프로그레스바</h2>
      <CatProgressAdvanced />
      <h2>스켈레톤 리스트</h2>
      <CatSkeletonList />

      <br />
      <br />
      <br />
      <br />
      ㅇㅇ

    </div>
  );
}