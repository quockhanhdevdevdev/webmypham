package source.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import source.model.DonHang;
import source.model.ThongKeDoanhThuDTO;

public interface DonHangRepository extends JpaRepository<DonHang, String> {

    @Query("SELECT new source.model.ThongKeDoanhThuDTO(MONTH(dh.NgayThang), SUM(dh.TongTien)) FROM DonHang dh WHERE dh.ThanhToan = true GROUP BY MONTH(dh.NgayThang)")
    List<ThongKeDoanhThuDTO> thongKeDoanhThu();

    @Query("From DonHang dh Where dh.MaDonHang = :idDonHang")
    DonHang findByIdDonHang(String idDonHang);
}
