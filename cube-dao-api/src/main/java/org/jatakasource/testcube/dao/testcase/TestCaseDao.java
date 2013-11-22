/**
 * TestCube is an enterprise Test management tool.
 * Copyright (C) 2011 JatakaSource Ltd.
 *
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * TestCube is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with TestCube.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.jatakasource.testcube.dao.testcase;

import java.util.List;

import org.jatakasource.common.dao.BaseDao;
import org.jatakasource.common.model.paging.Paging;
import org.jatakasource.common.model.paging.Sorting;
import org.jatakasource.testcube.model.testcase.ITestCase;
import org.jatakasource.testcube.model.testplan.ITestPlan;

public interface TestCaseDao extends BaseDao<ITestCase, Long> {
	List<ITestCase> findAll(Paging paging, Sorting sorting, String keyword, Long  productId, Long testPlanId);
	
	List<ITestCase> findAll(Paging paging, Sorting sorting, String keyword, Long testPlanId);
	
	Boolean isNameUniqe(ITestCase testcase, ITestPlan testPlan);
}
