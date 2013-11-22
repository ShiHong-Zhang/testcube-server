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
package org.jatakasource.testcube.model.testplan;

import java.util.Date;
import java.util.List;

import org.jatakasource.common.model.security.UserPojo;
import org.jatakasource.testcube.model.product.IProductRelated;
import org.jatakasource.testcube.model.product.VersionPojo;

public interface ITestPlan extends IProductRelated {

	Date getCreatedDate();

	void setCreatedDate(Date createdDate);

	UserPojo getCreatedBy();

	void setCreatedBy(UserPojo createdBy);

	PlanTypePojo getPlanType();

	void setPlanType(PlanTypePojo planType);

	VersionPojo getProductVersion();

	void setProductVersion(VersionPojo productVersion);

	<T extends PlanAttachmentPojo> List<T> getAttachments();

	<T extends PlanAttachmentPojo> void setAttachments(List<T> attachments);

	String getDocument();

	void setDocument(String document);
}
